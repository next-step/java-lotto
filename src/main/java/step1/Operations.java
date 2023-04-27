package step1;

import java.util.*;

public class Operations {
    private final Deque<Operation> operations = new ArrayDeque<>();

    public Operations() {
        operations.add(Operation.PLUS);
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
