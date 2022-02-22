package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operands {

    private final List<Operand> operands;

    public Operands(String[] numberStrings) {
        this.operands = parseOperands(numberStrings);
    }

    public List<Operand> parseOperands(String[] numbers) {
        return Arrays.stream(numbers)
            .map(Operand::new)
            .collect(Collectors.toList());
    }

    public List<Integer> getValues() {
        return operands.stream()
            .map(Operand::getValue)
            .collect(Collectors.toList());
    }

    public int getResult() {
        return operands.stream()
            .mapToInt(Operand::getValue)
            .sum();
    }
}
