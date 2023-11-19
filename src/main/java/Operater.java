import operation.Operation;

import java.util.*;

public class Operater {
    private Deque<Integer> numbers;
    private List<String> operations;
    
    private Operater(Deque<Integer> numbers, List<String> operations) {
        this.numbers = numbers;
        this.operations = operations;
    }

    public static Operater defaultOf(String numberAndOperation) {
        String[] numberOrOperations = numberAndOperation.split(" ");
        Deque<Integer> numbers = new LinkedList<>();
        List<String> operations = new ArrayList<>();

        for (String numberOrOperation: numberOrOperations) {
            judgeNumber(numberOrOperation, numbers);
            judgeOperation(numberOrOperation, operations);
        }

        return new Operater(numbers,operations);
    }

    private static void judgeOperation(String numberOrOperation, List<String> operations) {
        if (!isNumberic(numberOrOperation)) {
            operations.add(numberOrOperation);
        }
    }

    private static void judgeNumber(String numberOrOperation, Deque<Integer> numbers) {
        if (isNumberic(numberOrOperation)) {
            numbers.offer(Integer.parseInt(numberOrOperation));
        }
    }

    public static boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public int calculate(){
        for (int i = 0; i < operations.size(); i++) {
            String s = operations.get(i);
            int first = 0;
            int second = 0;
            Operation operation = OperationFactory.make(s);
            first = numbers.pop();
            second = numbers.pop();
            int result = operation.calculate(first, second);
            numbers.addFirst(result);
        }

        return numbers.peek();
    }
}
