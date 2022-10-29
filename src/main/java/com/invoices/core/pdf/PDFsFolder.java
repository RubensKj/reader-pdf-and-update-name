package com.invoices.core.pdf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PDFsFolder {

    public List<PdfInDirectoryDTO> readAllPDFsFromDirectory(String folderPath) {
        File folder = new File(folderPath);

        List<PdfInDirectoryDTO> paths = new ArrayList<>();

        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                System.out.println(fileEntry.getName() + " is a directory... Not reading...");
                continue;
            }
            paths.add(new PdfInDirectoryDTO(fileEntry.getName(), fileEntry.getPath()));
        }

        System.out.println("Read " + paths.size() + " pdfs in the folder...");

        return paths.stream()
                .filter(pdfInDirectoryDTO -> pdfInDirectoryDTO.getFileName().endsWith(".pdf"))
                .collect(Collectors.toList());
    }
}
