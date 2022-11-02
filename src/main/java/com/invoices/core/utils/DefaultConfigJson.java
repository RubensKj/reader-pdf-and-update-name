package com.invoices.core.utils;

import static com.invoices.core.utils.DefaultConfigUtils.*;

public class DefaultConfigJson {

    private String tesseractLanguage = TESSERACT_LANGUAGE;
    private String csvFilePath = CSV_FILE_PATH;
    private String pdfsNfes = PDFS_NFES;
    private String fileNameToReplace = FILENAME_TO_RENAME;

    private Integer indexOfCnpj = INDEX_OF_CNPJ;

    public DefaultConfigJson() {
    }

    public DefaultConfigJson(String tesseractLanguage, String csvFilePath, String pdfsNfes, String fileNameToReplace, Integer indexOfCnpj) {
        this.tesseractLanguage = tesseractLanguage;
        this.csvFilePath = csvFilePath;
        this.pdfsNfes = pdfsNfes;
        this.fileNameToReplace = fileNameToReplace;
        this.indexOfCnpj = indexOfCnpj;
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

    public String getFileNameToReplace() {
        return fileNameToReplace;
    }

    public void setFileNameToReplace(String fileNameToReplace) {
        this.fileNameToReplace = fileNameToReplace;
    }

    public Integer getIndexOfCnpj() {
        return indexOfCnpj;
    }

    public void setIndexOfCnpj(Integer indexOfCnpj) {
        this.indexOfCnpj = indexOfCnpj;
    }
}
