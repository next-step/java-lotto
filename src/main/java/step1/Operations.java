package step1;

import java.util.*;

public class Operations {
    private final Deque<Operation> operations = new ArrayDeque<>();

    public Operations(String[] numbersAndSigns) {
        operations.add(Operation.PLUS);
        for (int i = 1; i < numbersAndSigns.length; i = i + 2) {
            operations.add(Operation.toOperation(numbersAndSigns[i]));
        }
    }

    public Operation pop() {
        return operations.pop();
    }

    public boolean isEmpty() {
        return operations.isEmpty();
    }
}
