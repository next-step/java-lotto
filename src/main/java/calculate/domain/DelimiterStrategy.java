package calculate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DelimiterStrategy {
    private final Operands operands;
    private final Delimiter delimiter;

    public DelimiterStrategy(String operandString, String delimiterString) {
        this.delimiter = new Delimiter(delimiterString);

        List<String> delimitedString = splitOperandString(operandString);
        this.operands = new Operands(makeOperands(delimitedString));
    }

    private List<String> splitOperandString(String inputString) {
        if (Objects.isNull(inputString)) {
            return Arrays.asList("0");
        }
        return Arrays.asList(inputString.split(delimiter.getDelimiter()));
    }

    private List<Operand> makeOperands(List<String> delimitedString) {
        List<Operand> operands = new ArrayList<>();
        for (String str : delimitedString) {
            operands.add(new Operand(Integer.parseInt(str)));
        }
        return operands;
    }

    public Operands getOperands() {
        return operands;
    }

    public Delimiter getDelimiter() {
        return delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DelimiterStrategy that = (DelimiterStrategy) o;
        return Objects.equals(operands, that.operands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands);
    }
}
