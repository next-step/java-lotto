package step1;

import java.util.*;

public class Operations {
    private final Deque<Operation> operations = new ArrayDeque<>();

    public Operations() {
        operations.add(Operation.PLUS);
    }

    public static Operations toOperations(String[] numbersAndSigns) {
        Operations operations = new Operations();
        for (int i = 1; i < numbersAndSigns.length; i = i + 2) {
            operations.add(Operation.toOperation(numbersAndSigns[i]));
        }
        return operations;
    }

    public Operation pop() {
        return operations.pop();
    }

    public void add(Operation operation) {
        operations.add(operation);
    }

    public boolean isEmpty() {
        return operations.isEmpty();
    }
}
