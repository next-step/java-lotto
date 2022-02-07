package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import calculator.view.OutputView;

public class Parser {

    public static final String ERROR_NEGATIVE_NUMBER = "입력한 문자열에 음수가 있습니다.";
    private static final int CUSTOM_DELIMITER = 1;
    private static final int PARSED_FORMULAR = 2;

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\n(.*)");

    public List<Integer> splitCustomStringToNumber(String splitedFormular, String delimiter) {
        validateFormular(Arrays.asList(splitedFormular.split(delimiter)));
        return Arrays.asList(splitedFormular.split(delimiter)).stream()
            .map(Integer::parseInt).collect(
                Collectors.toList());
    }

    public ArrayList<String> splitCustom(String formula) {
        Matcher matcher = CUSTOM_PATTERN.matcher(formula);
        if (matcher.find()) {
            return new ArrayList<>(
                Arrays.asList(matcher.group(PARSED_FORMULAR), matcher.group(CUSTOM_DELIMITER)));
        }

        return new ArrayList<>(Arrays.asList(formula));
    }

    private void validateFormular(List<String> splitedFormular) {
        List<Integer> integeredFormular = stringListToInteger(splitedFormular);

        for (int formularNumber : integeredFormular) {
            if (formularNumber < 0) {
                throw new RuntimeException(OutputView.ERROR + ERROR_NEGATIVE_NUMBER);
            }
        }
    }

    private List<Integer> stringListToInteger(List<String> splitedFormular) {
        return splitedFormular.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
