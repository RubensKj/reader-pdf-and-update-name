package com.invoices.core.utils;

import static com.invoices.core.utils.DefaultConfigUtils.*;

public class DefaultConfigJson {

    private String tesseractLanguage = TESSERACT_LANGUAGE;
    private String csvFilePath = CSV_FILE_PATH;
    private String pdfsNfes = PDFS_NFES;

    public DefaultConfigJson() {
    }

    public DefaultConfigJson(String tesseractLanguage, String csvFilePath, String pdfsNfes) {
        this.tesseractLanguage = tesseractLanguage;
        this.csvFilePath = csvFilePath;
        this.pdfsNfes = pdfsNfes;
    }

    public String getTesseractLanguage() {
        return tesseractLanguage;
    }

    public void setTesseractLanguage(String tesseractLanguage) {
        this.tesseractLanguage = tesseractLanguage;
    }

    public String getCsvFilePath() {
        return csvFilePath;
    }

    public void setCsvFilePath(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public String getPdfsNfes() {
        return pdfsNfes;
    }

    public void setPdfsNfes(String pdfsNfes) {
        this.pdfsNfes = pdfsNfes;
    }
}
