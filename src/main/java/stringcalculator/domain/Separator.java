package stringcalculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {

    private final static List<String> DEFAULT_DELIMITERS = Arrays.asList(":", ",");
    private final static String DELIMITER_PREFIX = "\\";
    private final static String JOIN_STR = "|";

    private final String delimiters;
    private String numberString;

    public Separator(String numberString) {
        this.numberString = numberString;
        this.delimiters = createDelimiters(numberString);
    }

    private String createDelimiters(String text) {
        text = text.replace("\\n", "\n");

        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            delimiters.add(m.group(1));
            numberString = m.group(2);
        }
        return delimiters.stream()
            .map(delimiter -> DELIMITER_PREFIX + delimiter)
            .collect(Collectors.joining(JOIN_STR));
    }

    public List<String> split() {
        return Arrays.stream(numberString.split(delimiters))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}