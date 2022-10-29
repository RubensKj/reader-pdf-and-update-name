package com.invoices.core;

import com.invoices.core.csv.CSVReader;
import com.invoices.core.pdf.PDFsFolder;
import com.invoices.core.pdf.PdfInDirectoryDTO;

import java.util.HashMap;
import java.util.List;

public class ScriptService {
    public void execute() {
        CSVReader csvReader = new CSVReader();
        PDFsFolder pdfsFolder = new PDFsFolder();

        ConfigDTO configDTO = ConfigDTO.getInstance();

        HashMap<String, String> excelTableHash = csvReader
                .read(configDTO.getCsvFilePath());

        ReaderPDFService readerPDFService = new ReaderPDFService(excelTableHash);

        List<PdfInDirectoryDTO> pdfsPaths = pdfsFolder.readAllPDFsFromDirectory(configDTO.getPdfsNfes());

        readerPDFService.executeScript(pdfsPaths);
    }
}
