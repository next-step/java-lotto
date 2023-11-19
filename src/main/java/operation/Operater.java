package operation;

import java.util.*;

public class Operater {
    private Deque<Integer> numbers;
    private Operations operations;
    
    private Operater(Deque<Integer> numbers, Operations operations) {
        this.numbers = numbers;
        this.operations = operations;
    }

    public static Operater defaultOf(String numberAndOperation) {
        canMake(numberAndOperation);

        String[] numberOrOperations = numberAndOperation.split(" ");
        Deque<Integer> numbers = new LinkedList<>();
        List<String> operations = new ArrayList<>();
        Operations operations1 = Operations.defaultOf();

        for (String numberOrOperation: numberOrOperations) {
            addNumber(numberOrOperation, numbers);
            addOperation(numberOrOperation, operations1);
        }

        return new Operater(numbers,operations1);
    }

    private static void canMake(String numberAndOperation) {
        if (numberAndOperation == null) {
            throw new IllegalArgumentException("빈 문자열이 들어올 수 없습니다.");
        }

        if (numberAndOperation.trim().length() < 5) {
            throw new IllegalArgumentException("최소 두개의 숫자 하나의 연산자로 이루어져있어야 합니다.");
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
