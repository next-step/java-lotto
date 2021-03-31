package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OperandIntegers {

    private final List<OperandInteger> operandIntegers;

    public OperandIntegers(String[] inputIntegers) {
        this(Arrays.stream(inputIntegers).map(OperandInteger::new).collect(Collectors.toList()));
    }

    public OperandIntegers(List<OperandInteger> operandIntegers) {
        this.operandIntegers = operandIntegers;
    }

    public int sum() {
        OperandInteger total = new OperandInteger();
        for (OperandInteger operandInteger : operandIntegers) {
            total = total.sum(operandInteger);
        }
        return total.parseInteger();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperandIntegers that = (OperandIntegers) o;
        return Objects.equals(operandIntegers, that.operandIntegers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operandIntegers);
    }
}
