package calculator;

import java.util.ArrayList;
import java.util.List;

class Operands {
    public static final int MINIMUM_VALUE = 0;
    private final List<Operand> operands;

    Operands(List<Operand> input) {
        operands = new ArrayList<>(input);
    }

    Operand sum() {
        Operand result = Operand.of(MINIMUM_VALUE);
        for (Operand operand : operands) {
            result = result.add(operand);
        }
        return result;
    }
}
