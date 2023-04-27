package domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Operations {

    private Deque<Operation> operations;

    public Operations(List<Operation> operations) {
        this.operations = new LinkedList<>(operations);
    }

    public Operation next() {
        if (operations.isEmpty()) {
            return null;
        }
        return operations.pollFirst();
    }

}
