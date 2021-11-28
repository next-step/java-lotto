package calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Operands {

    private static final Operands EMPTY_OPERANDS = new Operands(Arrays.asList(Operand.ZERO));

    private final List<Operand> values;

    private Operands(List<Operand> values) {
        this.values = values;
    }

    public static Operands from(List<String> values) {
        if (values.isEmpty() || isEmptyStringOnly(values)) {
            return EMPTY_OPERANDS;
        }

        return new Operands(values.stream()
                .map(Operand::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)));
    }

    public int sumOf() {
        return values.stream()
                .mapToInt(Operand::getValue)
                .sum();
    }

    private static boolean isEmptyStringOnly(List<String> values) {
        return values.size() == 1 && values.contains("");
    }
}
