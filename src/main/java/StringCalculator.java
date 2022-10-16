import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private final TotalNumber totalNumber;

    public StringCalculator() {
        totalNumber = new TotalNumber(new Number("0"));
    }

    public long calculate(String input) throws IllegalArgumentException {
        if (!isCorrectFormedEquation(input)) throw new IllegalArgumentException("유효하지 않은 문자열입니다.");
        String[] numbersAndOperations = input.split(" ");

        Numbers numbers = extractNumbers(numbersAndOperations);
        Operations operations = extractOperations(numbersAndOperations);

        List<Number> numberList = numbers.getNumbers();
        List<Operation> operationList = operations.getOperations();

        totalNumber.add(numberList.get(0));
        for (int index = 0; index < operationList.size(); index++) {
            operate(operationList.get(index), numberList.get(index + 1));
        }

        return totalNumber.getTotal();
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
        // 사칙연산 ASCII 코드 기준으로 분기 처리
        // *: 42
        // +: 43
        // -: 45
        // /: 47
        if (first >= 42 && first <= 47) return false;
        if (last >= 42 && last <= 47) return false;
        return true;
    }
}
