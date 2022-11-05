import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

public final class StringCalculator {

    private static final int SINGLE = 1;
    private static final String DEFAULT_DELIMITER = " ";

    private StringCalculator() {
    }

    public static int compute(final String input) {
        validateInput(input);
        final List<String> inputs = split(input);
        final Queue<Operand> operands = mapToOperandQueue(inputs);
        final Queue<Operator> operators = mapToOperatorQueue(inputs);
        validatePreConditions(inputs, operands, operators);
        return compute(operands, operators);
    }

    private static int compute(final Queue<Operand> operands, final Queue<Operator> operators) {
        if (operands.size() == SINGLE) {
            return operands.poll().intValue();
        }
        final Operand startOperand = operands.poll();
        final Operand finalOperand = operands.stream()
            .reduce(startOperand, (partialResult, operand) ->
                Objects.requireNonNull(operators.poll()).apply(partialResult, operand));
        return finalOperand.intValue();
    }

    private static void validatePreConditions(
        final List<String> inputs,
        final Queue<Operand> operands,
        final Queue<Operator> operators
    ) {
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException("inputs can not be empty");
        }
        if (inputs.size() != (operands.size() + operators.size())) {
            throw new IllegalArgumentException("input contains invalid symbol");
        }
        if (operands.isEmpty()) {
            throw new IllegalArgumentException("operands can not be empty");
        }
        if (!(operators.size() == operands.size() - SINGLE)) {
            throw new IllegalArgumentException("input contains invalid symbol");
        }
    }

    private static void validateInput(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("input can not be null ");
        }
        if (input.isBlank()) {
            throw new IllegalArgumentException("input can not be blank");
        }
    }

    private static List<String> split(final String input) {
        return Arrays
            .stream(input.split(DEFAULT_DELIMITER))
            .map(String::strip)
            .collect(Collectors.toList());
    }

    private static Queue<Operator> mapToOperatorQueue(final List<String> inputs) {
        return inputs.stream()
            .map(Operator::fromString)
            .flatMap(Optional::stream)
            .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private static Queue<Operand> mapToOperandQueue(final List<String> inputs) {
        return inputs.stream()
            .filter(Operand::canParseOperand)
            .map(Operand::valueOf)
            .collect(Collectors.toCollection(ArrayDeque::new));
    }

}
