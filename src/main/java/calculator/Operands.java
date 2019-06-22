package calculator;

import java.util.ArrayList;
import java.util.List;

class Operands {
    private final List<Operand> operands;

    Operands(List<Operand> input) {
        operands = new ArrayList<>(input);
    }

    Operand sum() {
        Operand result = Operand.of(0);
        for (Operand operand : operands) {
            result = result.add(operand);
        }
        return result;
    }
}
