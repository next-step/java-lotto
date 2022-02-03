package domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    private final static int CUSTOM_SPLIT_STANDARD = 5;
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private String formula;

    public Parser(String formula) {
        this.formula = formula;
    }

    public List<Integer> splitStringToNumber() {
        return Arrays.asList(formula.split(",|:")).stream()
            .map(Integer::parseInt).collect(
                Collectors.toList());
    }

    public List<Integer> customSplitStringToNumber(String spliter) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(formula);
//        sb.delete(0,5);
        this.formula = formula.split("\n")[1];
//        this.formula = sb.toString();
        return Arrays.asList(formula.split(spliter + "|,|:")).stream()
            .map(Integer::parseInt).collect(
                Collectors.toList());
    }

    public String customSplit(String formula) {
        Matcher matcher = PATTERN.matcher(formula);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
        }

        if(formula.contains("//")) {
            return String.valueOf(formula.charAt(2));
        }
        return "";
    }
}
