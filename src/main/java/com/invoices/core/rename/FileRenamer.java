package com.invoices.core.rename;

import com.invoices.core.ConfigDTO;

import java.io.File;
import java.util.Objects;

import static com.invoices.core.utils.DefaultConfigUtils.ID_REPLACER_KEY;

public class FileRenamer {

    public void renameFile(String idByCNPJ, String fileName, String path) {
        File pdfFile = new File(path);

        String resolvedPath = path;
        resolvedPath = resolvedPath.replaceAll(fileName, "");

        String formattedFileName = renameFileTo(idByCNPJ, fileName);

        if (Objects.isNull(formattedFileName)) {
            System.out.println("File is already renamed... Skipping... FileName: " + fileName);
            return;
        }

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
        String fileNameFormatted = getReplacedFileName(idByCNPJ);

        if (fileName.startsWith(fileNameFormatted)) {
            return null;
        }

        return fileNameFormatted + fileName;
    }

    private String getReplacedFileName(String idByCNPJ) {
        ConfigDTO instance = ConfigDTO.getInstance();

        return instance.getFileNameToReplace().replace(ID_REPLACER_KEY, idByCNPJ);
    }
}
