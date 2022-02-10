package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import calculator.view.OutputView;

public class Parser {

    private static final String ERROR_NEGATIVE_NUMBER = "입력한 문자열에 음수가 있습니다.";
    private static final int CUSTOM_DELIMITER = 1;
    private static final int PARSED_FORMULAR = 2;
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\n(.*)");

    private String parsedFormular;
    private String customDelimiter;

    public Parser(String formula) {
        splitCustomFormular(formula);
    }

    public static List<Integer> makeToIntegerList(String splitedFormular, String delimiter) {
        List<String> delimiteredFormular = Arrays.asList(splitedFormular.split(delimiter));
        validateFormular(delimiteredFormular);
        return delimiteredFormular.stream()
            .map(Integer::parseInt).collect(
                Collectors.toList());
    }

    private void splitCustomFormular(String formula) {
        Matcher matcher = CUSTOM_PATTERN.matcher(formula);
        if (matcher.find()) {
            parsedFormular = matcher.group(PARSED_FORMULAR);
            customDelimiter = matcher.group(CUSTOM_DELIMITER);
        }
    }

    private static void validateFormular(List<String> splitedFormular) {
        List<Integer> integeredFormular = stringListToInteger(splitedFormular);
        for (int formularNumber : integeredFormular) {
            if (formularNumber < 0) {
                throw new RuntimeException(OutputView.ERROR + ERROR_NEGATIVE_NUMBER);
            }
        }
    }

    private static List<Integer> stringListToInteger(List<String> splitedFormular) {
        return splitedFormular.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public String getParsedFormular() {
        return parsedFormular;
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }

}
