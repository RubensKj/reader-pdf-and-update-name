package com.invoices.core.pdf;

import com.invoices.core.ConfigDTO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;


public class PDFReader {

    public String read(String pathPdf) {
        File pdfFile = new File(pathPdf);

        return extractTextFromPDF(pdfFile);
    }

    private String extractTextFromPDF(File pdfFile) {
        Tesseract tesseract = new Tesseract();

        ConfigDTO configDTO = ConfigDTO.getInstance();

        try {
            tesseract.setDatapath(getDatapath());
            tesseract.setLanguage(configDTO.getTesseractLanguage());

            tesseract.setOcrEngineMode(1);
            tesseract.setPageSegMode(1);

            return tesseract.doOCR(pdfFile);
        } catch (TesseractException e) {
            System.err.println("Erro ao extrair texto do PDF... Problema no extractTextFromPDF. Error: " + e.getMessage());
        }

        return null;
    }

    private String getDatapath() {
        File tmpFolder = LoadLibs.extractTessResources("tessdata");
        return tmpFolder.getPath();
//        return "lib/tessdata";
    }
}
