package step1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    private final String SPLIT_DELIMITER = " ";

    public int runOperation(String input) {
        String[] splitedByEmpty = validateAndSplit(input);
        List<Operation> operations = parseOperations(splitedByEmpty);
        List<Integer> operands = parseOperands(splitedByEmpty);
        Calculator calculator = new Calculator(operations, operands);
        return calculator.getResult();
    }

    private List<Integer> parseOperands(String[] splitedByEmpty) {
        List<String> operandsString = this.filterOperand(splitedByEmpty);
        return this.castOperandInteger(operandsString);
    }

    private List<Operation> parseOperations(String[] splitedByEmpty) {
        List<String> operationsString = this.filterOperation(splitedByEmpty);
        return this.castOperationEnums(operationsString);
    }

    private String[] validateAndSplit(String input) {
        this.emptyValidate(input);
        String trimedInput = input.trim();
        return this.splitByEmptyString(trimedInput);
    }

    private List<Integer> castOperandInteger(List<String> splitedByEmpty) {
        splitedByEmpty.forEach(this::validateIntegerString);
        return splitedByEmpty.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateIntegerString(String operandString) {
        if (!operandString.matches("-?\\d+")) {
            throw new IllegalArgumentException(operandString + "은 정수가 아닙니다.");
        }
    }

    private List<Operation> castOperationEnums(List<String> operationsString) {
        return operationsString.stream()
                .map(Operation::castOperation)
                .collect(Collectors.toList());
    }

    private void emptyValidate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null값은 사칙연산을 할 수 없습니다.");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 사칙연산을 할 수 없습니다.");
        }
    }

    private List<String> filterOperation(String[] splitedInput) {
        return IntStream.range(0, splitedInput.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> splitedInput[i])
                .collect(Collectors.toList());
    }

    private List<String> filterOperand(String[] splitedInput) {
        return IntStream.range(0, splitedInput.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> splitedInput[i])
                .collect(Collectors.toList());
    }

    private String[] splitByEmptyString(String trimedInput) {
        return trimedInput.split(SPLIT_DELIMITER);
    }

}
