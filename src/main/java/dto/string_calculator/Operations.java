package dto.string_calculator;

import java.util.List;

public class Operations {
    private final List<Operation> operations;

    public Operations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
