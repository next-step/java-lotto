package calculate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DelimiterStrategy {
    private final Operands operands;

    public DelimiterStrategy(String s, Delimiter delimiter) {
        List<String> strings = Arrays.asList(s.split(delimiter.getDelimiter()));
        List<Operand> operands = new ArrayList<>();

        for (String str : strings) {
            operands.add(new Operand(Integer.parseInt(str)));
        }
        this.operands = new Operands(operands);
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
