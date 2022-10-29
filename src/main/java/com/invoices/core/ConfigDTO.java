package com.invoices.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.invoices.core.utils.DefaultConfigUtils.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigDTO {

    private static ConfigDTO instance;

    private String tesseractLanguage;
    private String csvFilePath;
    private String pdfsNfes;

    public ConfigDTO() {
        instance = this;
    }

    public ConfigDTO(String tesseractLanguage, String csvFilePath, String pdfsNfes) {
        this.tesseractLanguage = tesseractLanguage;
        this.csvFilePath = csvFilePath;
        this.pdfsNfes = pdfsNfes;
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

    public static ConfigDTO getInstance() {
        if (instance == null) {
            System.out.println("Config instance is null... Creating new one with default paths...");
            instance = new ConfigDTO(
                    TESSERACT_LANGUAGE,
                    CSV_FILE_PATH,
                    PDFS_NFES
            );
        }

        return instance;
    }

    @Override
    public String toString() {
        return "ConfigDTO{" +
                "'tesseractLanguage='" + tesseractLanguage + '\'' +
                ", csvFilePath='" + csvFilePath + '\'' +
                ", pdfsNfes='" + pdfsNfes + '\'' +
                '}';
    }
}
