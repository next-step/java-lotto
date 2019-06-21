package calculator;

import java.util.ArrayList;
import java.util.List;

public class Operands {
    private final List<Operand> operands;

    public Operands(List<Operand> input) {
        operands = new ArrayList<>(input);
    }

    public Operand sum() {
        Operand result = Operand.of(0);
        for (Operand operand : operands) {
            result = result.add(operand);
        }
        return result;
    }
}
