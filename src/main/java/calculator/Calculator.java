package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int calculate(String str) {
        List<String> expressions = new ArrayList<>(Arrays.asList(filterValidInput(str).split(" ")));
        List<Operation> operations = filterValidOperations(filterNotNumerics(expressions));
        List<Integer> numbers = filterValidNumbers(filterNumerics(expressions));
        checkValidExpressions(numbers, operations);
        return run(numbers, operations);
    }

    private int run(List<Integer> numbers, List<Operation> operations) {
        ArrayList<Integer> mutableNumbers = new ArrayList<>(numbers);
        for (Operation operation : operations) {
            int leftNumber = mutableNumbers.remove(0);
            int rightNumber = mutableNumbers.remove(0);
            int result = operation.applyAsInt(leftNumber, rightNumber);
            mutableNumbers.add(0, result);
        }
        return mutableNumbers.get(0);
    }

    private void checkValidExpressions(List<Integer> numbers, List<Operation> operations) {
        if (numbers.size() - 1 != operations.size()) {
            throw new IllegalArgumentException("유효하지 않은 수식입니다.");
        }
    }

    private List<Integer> filterValidNumbers(List<String> expressions) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String expression : expressions) {
            int number = Integer.parseInt(expression);
            numbers.add(number);
        }
        return numbers;
    }

    private String filterValidInput(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("널 또는 공백 입력");
        }
        return str;
    }

    private List<Operation> filterValidOperations(List<String> expressions) {
        ArrayList<Operation> operations = new ArrayList<>();
        for (String expression : expressions) {
            Operation operation = Operation.toOperation(expression);
            operations.add(operation);
        }
        return operations;
    }

    private List<String> filterNotNumerics(List<String> expressions) {
        return expressions.stream().filter(expression -> !isNumeric(expression)).collect(Collectors.toList());
    }

    private List<String> filterNumerics(List<String> expressions) {
        return expressions.stream().filter(expression -> isNumeric(expression)).collect(Collectors.toList());
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }

}
