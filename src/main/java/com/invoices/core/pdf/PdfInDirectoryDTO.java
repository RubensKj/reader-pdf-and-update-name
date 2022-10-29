package com.invoices.core.pdf;

public class PdfInDirectoryDTO {

    private String fileName;
    private String path;

    public PdfInDirectoryDTO(String fileName, String path) {
        this.fileName = fileName;
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public String getPath() {
        return path;
    }
}
