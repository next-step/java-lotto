package step1;

import step1.operation.Operation;
import step1.operation.PlusOperation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Operations {

    private final Deque<Operation> operations = new ArrayDeque<>();

    public Operations() {
        operations.add(new PlusOperation());
    }

    public Operation pop() {
        return operations.pop();
    }

    public void add(Operation operation) {
        operations.add(operation);
    }


}
