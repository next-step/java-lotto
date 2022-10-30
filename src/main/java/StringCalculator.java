import dto.string_calculator.*;
import dto.string_calculator.Number;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private final TotalNumber totalNumber;

    private static final int MULTIPLY_ASCII = 42;
    private static final int PLUS_ASCII = 43;
    private static final int MINUS_ASCII = 45;
    private static final int DIVIDE_ASCII = 47;

    public StringCalculator() {
        totalNumber = new TotalNumber(new Number("0"));
    }

    public long calculate(String input) throws IllegalArgumentException {
        if (!isCorrectFormedEquation(input)) {
            throw new IllegalArgumentException("유효하지 않은 문자열입니다.");
        }

        Numbers numbers = extractNumbers(input.split(" "));
        Operations operations = extractOperations(input.split(" "));

        calculate(numbers, operations);

        return totalNumber.getTotal();
    }

    private void calculate(Numbers numbers, Operations operations) {
        totalNumber.add(numbers.fromList().get(0));
        for (int index = 0; index < operations.getOperations().size(); index++) {
            operate(operations.getOperations().get(index), numbers.fromList().get(index + 1));
        }
    }

    private void operate(@NotNull Operation operation, Number number) {
        switch (operation.getOperation()) {
            case "+":
                totalNumber.add(number);
                break;
            case "-":
                totalNumber.subtract(number);
                break;
            case "/":
                totalNumber.divide(number);
                break;
            case "*":
                totalNumber.multiply(number);
                break;
        }
    }

    private @NotNull Operations extractOperations(String @NotNull [] numbersAndOperations) {
        List<Operation> operationList = new ArrayList<>();
        for (int index = 1; index < numbersAndOperations.length; index += 2) {
            operationList.add(new Operation(numbersAndOperations[index]));
        }

        return new Operations(operationList);
    }

    private @NotNull Numbers extractNumbers(String @NotNull [] numbersAndOperations) {
        List<Number> numberList = new ArrayList<>();
        for (int index = 0; index < numbersAndOperations.length; index += 2) {
            numberList.add(new Number(numbersAndOperations[index]));
        }

        return new Numbers(numberList);
    }

    private boolean isCorrectFormedEquation(@NotNull String input) {
        if (input.isBlank() || input.isEmpty()) return false;

        return startsAndEndsWithNumber(input.charAt(0), input.charAt(input.length() - 1));
    }

    private boolean startsAndEndsWithNumber(Character first, Character last) {
        if (first >= MULTIPLY_ASCII && first <= DIVIDE_ASCII) return false;
        if (last >= MULTIPLY_ASCII && last <= DIVIDE_ASCII) return false;
        return true;
    }
}
