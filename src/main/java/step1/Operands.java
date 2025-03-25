package step1;

import java.util.ArrayList;
import java.util.List;

public class Operands {
    private final List<Operand> operands;

    public Operands(List<String> input) {
        operands = new ArrayList<>();
        for (String operand : input) {
            operands.add(new Operand(operand));
        }
    }

    public Operand get(int index) {
        return operands.get(index);
    }

    public int size() {
        return operands.size();
    }
}
