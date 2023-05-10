package calculator;

import calculator.biz.enums.OperatorEnum;

import java.util.regex.Pattern;

public class StringCalculator {
    public static final String EMPTY_DELIMITER = " ";
    public final String PATTERN = "[^0-9+*/\\-/\\s]";
    public final Pattern VALIDATE_REGEXR = Pattern.compile(PATTERN);

    public final String FOUR_FUNDAMENTAL = "[+\\-*/]";
    public final Pattern FOUR_FUNDAMENTAL_VALIDATE_REGEXR = Pattern.compile(FOUR_FUNDAMENTAL);

    public int calculate(String input) {
        return getResult(inputSplitByDelimiter(validateData(input), EMPTY_DELIMITER));
    }

    private int getResult(String[] chars) {
        int result = parseToInt(chars[0]);
        for (int i = 1; i < chars.length; i += 2) {
            result = OperatorEnum.findOperator(chars[i])
                                 .apply(result, parseToInt(chars[i + 1]));
        }
        return result;
    }

    private String[] inputSplitByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }


    private String validateData(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("입력값은 null 또는 빈공백 값이 될수 없습니다. 확인해주세요.");

        if (VALIDATE_REGEXR.matcher(input).find())
            throw new IllegalArgumentException("숫자, 공백, 사측연산 기호 외의 문자가 포함되어있습니다.");

        return input;
    }

    public int parseToInt(String value) {
        return Integer.parseInt(value);
    }
}
