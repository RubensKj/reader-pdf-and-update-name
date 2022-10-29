package com.invoices.core.domain;

import java.util.HashMap;

import static com.invoices.core.utils.CNPJUtils.removeCNPFMask;

public class ExcelTable {

    private final HashMap<String, String> linesFromCsv;

    public ExcelTable(HashMap<String, String> linesFromCsv) {
        this.linesFromCsv = linesFromCsv;
    }


    public String getIdByCNPJ(String cnpj) {
        return linesFromCsv.get(removeCNPFMask(cnpj));
    }
}
