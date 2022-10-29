package com.invoices.core.utils;

public class CNPJUtils {

    private CNPJUtils() {
    }

    public static String removeCNPFMask(String cnpj) {
        return cnpj
                .replaceAll("\\.", "")
                .replaceAll("-", "")
                .replaceAll("/", "");
    }
}
