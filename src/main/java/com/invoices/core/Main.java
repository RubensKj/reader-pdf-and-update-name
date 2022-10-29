package com.invoices.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invoices.core.csv.GenericFileReader;
import com.invoices.core.utils.DefaultConfigJson;

import javax.swing.*;
import java.util.List;

import static com.invoices.core.ConfigDTO.getInstance;
import static com.invoices.core.utils.DefaultConfigUtils.DEFAULT_JSON_CONFIG;

public class Main {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        readJsonConfig(args);
        printConfigText();
        System.out.println("Initializing script renamer pdf with id by CNPJ...\n\n");

        ScriptService scriptService = new ScriptService();

        scriptService.execute();

        System.out.println("\n\nFinishing the process... Script is over. Everything renamed.");
    }

    private static void readJsonConfig(String[] args) {
        String jsonPath = null;

        if (args.length > 0 && args[0].contains("--config")) {
            jsonPath = JOptionPane.showInputDialog("Digite o caminho para o arquivo de configuração (JSON):");
        }

        if (isValidPath(jsonPath)) {
            System.out.println("Receive PATH: " + jsonPath);
        } else {
            String defaultJsonConfig = DEFAULT_JSON_CONFIG;

            System.out.println("Using default path for config... Path: " + defaultJsonConfig);
            jsonPath = defaultJsonConfig;
        }

        GenericFileReader genericFileReader = new GenericFileReader();

        OBJECT_MAPPER.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

        try {
            List<String> lines = genericFileReader.read(jsonPath, true, getDefaultJsonConfig());
            String json = String.join("", lines);

            if (json.isEmpty()) {
                System.out.println("Error getting content from json config...");
                return;
            }

            // Will set the ConfigDTO with the params
            ConfigDTO configDTO = OBJECT_MAPPER.readValue(json, ConfigDTO.class);
            System.out.println("ConfigDTO configured from json. ConfigDTO: " + configDTO.toString());
        } catch (JsonProcessingException e) {
            System.err.println("Error parsing config DTO...");
            throw new RuntimeException(e);
        }
    }

    private static String getDefaultJsonConfig() throws JsonProcessingException {
        return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(new DefaultConfigJson());
    }

    private static boolean isValidPath(String jsonPath) {
        return jsonPath != null && (jsonPath.length() != 0);
    }

    private static void printConfigText() {
        ConfigDTO instance = getInstance();

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("TESSERACT-CONFIG");
        System.out.println("\tTESSERACT_LANGUAGE: " + instance.getTesseractLanguage());
        System.out.println("CSV-CONFIG");
        System.out.println("\tCSV_FILE_PATH: " + instance.getCsvFilePath());
        System.out.println("PDFS-CONFIG");
        System.out.println("\tPDFS_NFEs: " + instance.getPdfsNfes());
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println();
    }
}