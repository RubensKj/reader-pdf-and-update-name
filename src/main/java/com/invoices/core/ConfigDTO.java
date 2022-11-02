package com.invoices.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.invoices.core.utils.DefaultConfigUtils.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigDTO {

    private static ConfigDTO instance;

    private String tesseractLanguage;
    private String csvFilePath;
    private String pdfsNfes;
    private String fileNameToReplace;
    private Integer indexOfCnpj;

    public ConfigDTO() {
        instance = this;
    }

    public ConfigDTO(String tesseractLanguage, String csvFilePath, String pdfsNfes, String fileNameToReplace, Integer indexOfCnpj) {
        this.tesseractLanguage = tesseractLanguage;
        this.csvFilePath = csvFilePath;
        this.pdfsNfes = pdfsNfes;
        this.fileNameToReplace = fileNameToReplace;
        this.indexOfCnpj = indexOfCnpj;
        instance = this;
    }

    public String getTesseractLanguage() {
        return tesseractLanguage;
    }

    public String getCsvFilePath() {
        return csvFilePath;
    }

    public String getPdfsNfes() {
        return pdfsNfes;
    }

    public void setTesseractLanguage(String tesseractLanguage) {
        this.tesseractLanguage = tesseractLanguage;
    }

    public void setCsvFilePath(String csvFilePath) {
        this.csvFilePath = csvFilePath;
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

    public static ConfigDTO getInstance() {
        if (instance == null) {
            System.out.println("Config instance is null... Creating new one with default paths...");
            instance = new ConfigDTO(
                    TESSERACT_LANGUAGE,
                    CSV_FILE_PATH,
                    PDFS_NFES,
                    FILENAME_TO_RENAME,
                    INDEX_OF_CNPJ
            );
        }

        return instance;
    }

    @Override
    public String toString() {
        return "ConfigDTO{" +
                "tesseractLanguage='" + tesseractLanguage + '\'' +
                ", csvFilePath='" + csvFilePath + '\'' +
                ", pdfsNfes='" + pdfsNfes + '\'' +
                ", fileNameToReplace='" + fileNameToReplace + '\'' +
                ", indexOfCnpj=" + indexOfCnpj +
                '}';
    }
}
