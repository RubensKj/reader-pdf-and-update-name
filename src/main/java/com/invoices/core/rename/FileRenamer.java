package com.invoices.core.rename;

import java.io.File;

public class FileRenamer {

    public void renameFile(String idByCNPJ, String fileName, String path) {
        File pdfFile = new File(path);

        String resolvedPath = path;
        resolvedPath = resolvedPath.replaceAll(fileName, "");

        String formattedFileName = renameFileTo(idByCNPJ, fileName);

        File fileWithNewName = new File(resolvedPath + formattedFileName);

        boolean isRenamed = pdfFile.renameTo(fileWithNewName);

        if (!isRenamed) {
            System.out.println("Could not rename file: " + fileName);
            return;
        }

        System.out.println("Renamed file \"" + fileName + "\" to \"" + formattedFileName + "\"");
    }

    // What the fileName will look like with the id in it.
    private String renameFileTo(String idByCNPJ, String fileName) {
        if (fileName.startsWith(idByCNPJ)) {
            return fileName;
        }

        return "RBA " + idByCNPJ + "_" + fileName;
    }
}
