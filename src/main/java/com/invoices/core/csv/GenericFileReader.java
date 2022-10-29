package com.invoices.core.csv;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class GenericFileReader {
    public List<String> read(String filePath) {
        return read(filePath, false);
    }

    public List<String> read(String filePath, boolean createIfNotExists) {
        return read(filePath, createIfNotExists, "");
    }

    public List<String> read(String filePath, boolean createIfNotExists, String content) {
        List<String> lines = new ArrayList<>();

        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            if (createIfNotExists) {
                System.out.println("File not found, creating one...");
                try {
                    Path path = Paths.get(filePath);
                    Files.createFile(path);
                    Files.write(
                            path,
                            content.getBytes(),
                            StandardOpenOption.APPEND);
                    System.out.println("File created...");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
