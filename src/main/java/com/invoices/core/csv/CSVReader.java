package com.invoices.core.csv;

import java.util.HashMap;
import java.util.List;

import static com.invoices.core.utils.CNPJUtils.removeCNPFMask;

public class CSVReader {
    private static final String DELIMITER = ";";

    private final GenericFileReader genericFileReader = new GenericFileReader();

    public HashMap<String, String> read(String csvFile) {
        HashMap<String, String> linesFromCsv = new HashMap<>();

        List<String> lines = genericFileReader.read(csvFile);

        for (String line : lines) {
            var splittedLine = line.split(DELIMITER);

            if (splittedLine.length > 0) {
                linesFromCsv.put(removeCNPFMask(splittedLine[0]), splittedLine[1]);
            }
        }

        return linesFromCsv;
    }
}
