package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {

    private static final int CUSTOM_DELIMITER = 1;
    private static final int PARSED_FORMULAR = 2;

    private static final Pattern PATTERN = Pattern.compile("//(.)\\n(.*)");
    private String formula;

    public Parser(String formula) {
        this.formula = formula;
    }

    public List<Integer> customSplitStringToNumber(String splitedFormular, String delimiter) {
        return Arrays.asList(splitedFormular.split(delimiter)).stream()
            .map(Integer::parseInt).collect(
                Collectors.toList());
    }


    public ArrayList<String> customSplit(String formula) {
        Matcher matcher = PATTERN.matcher(formula);

        if (matcher.find()) {
            return new ArrayList<>(
                Arrays.asList(matcher.group(CUSTOM_DELIMITER), matcher.group(PARSED_FORMULAR)));
        }

        return new ArrayList<>(Arrays.asList(formula));
    }
}
