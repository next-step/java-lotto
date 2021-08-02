package StringCalculator.domain;

import StringCalculator.exception.WrongInputException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OperationInputs {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String ALLOWED_OPERANDS_REGEX = "\\d*";
    private static final String ZERO_STRING = "0";

    private final List<Integer> operands;
    private final OperateStrategy strategy;


    public OperationInputs(String userInput, OperateStrategy strategy) {
        List<Integer> operands = generateOperands(userInput);

        this.strategy = strategy;
        this.operands = operands;
    }

    public OperationInputs(List<Integer> operands, OperateStrategy strategy) {
        this.strategy = strategy;
        this.operands = operands;
    }

    private List<Integer> generateOperands(String userInput) {
        String[] splitStrings = splitStringByDelimiter(userInput);
        List<Integer> operands = convertStringArrayToIntList(splitStrings);

        return operands;
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

    private String[] splitStringByDelimiter(String userInput) {

        if (checkNullOrEmpty(userInput)) {
            return new String[]{ZERO_STRING};
        }
        return userInput.split(DEFAULT_DELIMITER_REGEX);

    }

    private boolean checkNullOrEmpty(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return true;
        }
        return false;
    }


    public List<Integer> getOperands() {
        return operands;
    }

    public OperateStrategy getStrategy() {
        return strategy;
    }
}
