package StringCalculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OperationInputs {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final int ZERO = 0;

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
        List<Integer> operands = new ArrayList<>();
        splitStringByDelimiter(userInput);

        return operands;
    }

    private List<Integer> splitStringByDelimiter(String userInput) {

        if (checkNullOrEmpty(userInput)) {
            List<Integer> operands = new ArrayList<>();
            operands.add(ZERO);
            return operands;
        }

        return Arrays.stream(userInput.split(DEFAULT_DELIMITER_REGEX))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());

    }

    private boolean checkNullOrEmpty(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
