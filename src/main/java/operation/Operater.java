package operation;

import java.util.Deque;
import java.util.LinkedList;

public class Operater {
    private Deque<Integer> numbers;
    private Operations operations;

    private Operater(Deque<Integer> numbers, Operations operations) {
        this.numbers = numbers;
        this.operations = operations;
    }

    public static Operater defaultOf(String numberAndOperation) {
        validate(numberAndOperation);

        String[] numberOrOperations = numberAndOperation.split(" ");
        Deque<Integer> numbers = new LinkedList<>();
        Operations operations = Operations.defaultOf();

        for (String numberOrOperation: numberOrOperations) {
            addNumber(numberOrOperation, numbers);
            addOperation(numberOrOperation, operations);
        }

        return new Operater(numbers,operations);
    }

    private static void validate(String numberAndOperation) {
        validateEmptyOrNull(numberAndOperation);
        validateMinimumSize(numberAndOperation);
    }

    private static void validateMinimumSize(String numberAndOperation) {
        if (numberAndOperation.trim().length() < 5) {
            throw new IllegalArgumentException("최소 두개의 숫자 하나의 연산자로 이루어져있어야 합니다.");
        }
    }

    private static void validateEmptyOrNull(String numberAndOperation) {
        if (numberAndOperation == null || numberAndOperation.trim().isBlank()) {
            throw new IllegalArgumentException("빈 문자열이 들어올 수 없습니다.");
        }
    }

    private static void addOperation(String numberOrOperation, Operations operations) {
        if (!isNumberic(numberOrOperation)) {
            operations.add(numberOrOperation);
        }
    }

    private static void addNumber(String numberOrOperation, Deque<Integer> numbers) {
        if (isNumberic(numberOrOperation)) {
            numbers.offer(Integer.parseInt(numberOrOperation));
        }
    }

    private static boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public int calculate() {
        return this.operations.calculate(this.numbers);
    }
}
