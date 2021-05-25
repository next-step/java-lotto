package kr.aterilio.nextstep.techcamp.m1.calculator;

public class Parser {

    private static final int IDX_MIN_CUSTOM_DELIMITER = 0;

    private static final String REGEX_SPLIT_BY = ",|:";
    private static final String DELIMITER_CONNECTOR = "|";

    private static final String REGEX_CUSTOM_DELIMITER = "//(.)\\n";

    private static final String MSG_ERR_INPUT_CUSTOM_DELIMITER_POSITION = "커스텀 구분자의 위치가 올바르지 않습니다.";
    private static final String MSG_ERR_INPUT_NEGATIVE = "음수는 입력할 수 없습니다.";
    private static final String MSG_ERR_INPUT_ALLOW = "올바른 값을 입력하세요. 숫자와 구분자만 입력할 수 있습니다.";

    public static Integer[] parse(String formula) {
        validateCustomDelimiter(formula);
        String[] units = splitUnits(formula);
        return convertToIntegers(units);
    }

    private static void validateCustomDelimiter(String formula) {
        int positionRegEx = StringUtil.positionRegEx(formula, REGEX_CUSTOM_DELIMITER);
        if (positionRegEx > IDX_MIN_CUSTOM_DELIMITER) {
            throw new IllegalArgumentException(MSG_ERR_INPUT_CUSTOM_DELIMITER_POSITION);
        }
    }

    private static String[] splitUnits(String formula) {
        String customDelimiter = StringUtil.extractRegEx(formula, REGEX_CUSTOM_DELIMITER);
        if (StringUtil.isEmpty(customDelimiter)) {
            return StringUtil.split(formula, REGEX_SPLIT_BY);
        }
        return StringUtil.split(
                StringUtil.removeAllRegEx(formula, REGEX_CUSTOM_DELIMITER),
                joinDelimiterRegEx(customDelimiter)
        );
    }

    private static String joinDelimiterRegEx(String customDelimiter) {
        return String.join(DELIMITER_CONNECTOR, REGEX_SPLIT_BY, customDelimiter);
    }

    private static Integer[] convertToIntegers(String[] inputs) {
        Integer[] numbers = new Integer[inputs.length];
        for(int i = inputs.length-1; i >= 0; --i) {
            validateNumeric(inputs[i]);
            int number = Integer.parseInt(inputs[i]);
            validatePositive(number);
            numbers[i] = number;
        }
        return numbers;
    }

    private static void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(MSG_ERR_INPUT_NEGATIVE);
        }
    }

    private static void validateNumeric(String formula) {
        if (!StringUtil.isNumeric(formula)) {
            throw new IllegalArgumentException(MSG_ERR_INPUT_ALLOW);
        }
    }
}
