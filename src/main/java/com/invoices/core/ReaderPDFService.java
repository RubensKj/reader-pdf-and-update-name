package com.invoices.core;

import com.invoices.core.domain.ExcelTable;
import com.invoices.core.pdf.PDFReader;
import com.invoices.core.pdf.PdfInDirectoryDTO;
import com.invoices.core.regex.CNPJRegex;
import com.invoices.core.rename.FileRenamer;

import java.util.HashMap;
import java.util.List;

public class ReaderPDFService {

    private final CNPJRegex cnpjRegex = new CNPJRegex();
    private final PDFReader pdfReader = new PDFReader();
    private final FileRenamer fileRenamer = new FileRenamer();
    private final ExcelTable excelTable;

    public ReaderPDFService(HashMap<String, String> linesFromCsv) {
        this.excelTable = new ExcelTable(linesFromCsv);
    }

    public void executeScript(List<PdfInDirectoryDTO> pdfsPaths) {
        for (int i = 0; i < pdfsPaths.size(); i++) {
            System.out.println("Reading PDF " + (i + 1) + " from a total " + pdfsPaths.size() + ".");
            PdfInDirectoryDTO pdfPath = pdfsPaths.get(i);

            String textFromPdf = pdfReader.read(pdfPath.getPath());

            List<String> cnpjsFromText = cnpjRegex.getCNPJsFromText(textFromPdf);

            System.out.println("CNPJs encontrados: " + cnpjsFromText);

            String cnpj = getCnpjFromTomador(cnpjsFromText);

            if (cnpj == null) {
                System.out.println("Not found CNPJ in list of cnpjs from image. List size: " + cnpjsFromText.size());
                continue;
            }

            String idByCNPJ = excelTable.getIdByCNPJ(cnpj);

            if (idByCNPJ == null) {
                System.out.println("Not found id for CNPJ: " + cnpj);
                continue;
            }

            fileRenamer.renameFile(idByCNPJ, pdfPath.getFileName(), pdfPath.getPath());
        }
    }

    private static String getCnpjFromTomador(List<String> cnpjsFromText) {
        if (cnpjsFromText.get(1) == null) {
            return cnpjsFromText.get(0);
        }

        return cnpjsFromText.get(1);
    }
}
