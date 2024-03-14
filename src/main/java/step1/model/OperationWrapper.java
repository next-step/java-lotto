package step1.model;

import step1.calculator.Operation;
import step1.validator.OperationValidator;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static step1.calculator.Operation.find;

public class OperationWrapper {
    private static final OperationValidator validator = new OperationValidator();
    private final List<Integer> operands;
    private final List<Operation> operations;

    private OperationWrapper(List<Integer> operands, List<Operation> operations) {
        this.operands = operands;
        this.operations = operations;
    }

    public static OperationWrapper from(String input) {
        validator.assertOperation(input);

        String[] tokens = input.split(" ");
        return new OperationWrapper(parseOperands(tokens), parseOperation(tokens));
    }

    private static List<Integer> parseOperands(String[] tokens) {
        return IntStream.range(0, tokens.length)
                .filter(idx -> idx % 2 == 0)
                .mapToObj(idx -> Integer.valueOf(tokens[idx]))
                .collect(toList());
    }

    private static List<Operation> parseOperation(String[] tokens) {
        return IntStream.range(0, tokens.length)
                .filter(idx -> idx % 2 == 1)
                .mapToObj(idx -> find(tokens[idx]))
                .collect(toList());
    }

    public int result() {
        int result = operands.get(0);
        for (int i = 1; i < operands.size(); i++) {
            int operand = operands.get(i);
            Operation operation = operations.get(i - 1);

            result = operation.apply(result, operand);
        }

        return result;
    }
}
