package StringCalculator.domain;

import StringCalculator.exception.WrongInputException;
import StringCalculator.util.StringUtils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operands {

    private static final String ALLOWED_OPERANDS_REGEX = "\\d*";
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String ZERO_STRING = "0";

    private final List<Integer> operands;


    private Operands(String operandString) {
        this(operandString, DEFAULT_DELIMITER_REGEX);
    }

    private Operands(String operandString, String delimiter) {
        List<Integer> operands = generateOperands(operandString, delimiter);
        this.operands = operands;
    }


    public static Operands createByCustomDelimiter(String operandString, String customDelimiter) {
        return new Operands(operandString, customDelimiter);
    }

    public static Operands createByDefaultDelimiter(String operandString) {
        return new Operands(operandString);
    }


    private List<Integer> generateOperands(String operandString, String delimiter) {
        String[] splitStrings = splitStringByDelimiter(operandString, delimiter);
        List<Integer> operands = convertStringArrayToIntList(splitStrings);

        return operands;
    }

    private String[] splitStringByDelimiter(String userInput, String delimiter) {

        if (StringUtils.checkNullOrEmpty(userInput)) {
            return new String[]{ZERO_STRING};
        }
        return userInput.split(delimiter);
    }

    private List<Integer> convertStringArrayToIntList(String[] splitStrings) {
        return Arrays.stream(splitStrings)
            .filter(s -> {
                if (isNotAllowedOperand(s)) {
                    throw new WrongInputException(String.format("'%s'는 유효한 피연산자가 아닙니다.", s));
                }
                return true;
            })
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    private boolean isNotAllowedOperand(String s) {
        return !s.matches(ALLOWED_OPERANDS_REGEX);
    }


    public List<Integer> value() {
        return operands;
    }
}
