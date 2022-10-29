package com.invoices.core.regex;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CNPJRegex {
//    private static final String REGEX = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";
    private static final String REGEX = "(([0-9]{2}[\\.][0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2}))|([0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[-][0-9]{2})";

    public List<String> getCNPJsFromText(String text) {
        Pattern pattern = Pattern.compile(REGEX);

        return pattern.matcher(text)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
    }
}
