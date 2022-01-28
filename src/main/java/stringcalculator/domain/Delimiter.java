package stringcalculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private final static String CUSTOM_DELIMITER = "//([^0-9])\\n";
    private final static String[] DEFAULT_DELIMITER = new String[]{",", ":"};

    private List<String> delimiters;
    private List<String> tokens;

    public Delimiter(final String input) {
        this.delimiters = new ArrayList<>(Arrays.asList(DEFAULT_DELIMITER));
        this.tokens = splitByDelimiter(findCustomDelimiter(input));
    }

    private String findCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            addCustomDelimiter(matcher.group(1));
            return input.replaceFirst(matcher.group(0), "");
        }
        return input;
    }

    private void addCustomDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

    private List<String> splitByDelimiter(String input) {
        return Arrays.asList(input.split(String.join("|", delimiters)));
    }

    public List<String> getNumbers() {
        return tokens;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }
}
