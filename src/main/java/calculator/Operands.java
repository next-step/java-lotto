package calculator;

import java.util.List;

public class Operands {

    public static final int START_SUM_VALUE = 0;

    private final List<Integer> operands;

    public Operands(List<Integer> operands) {
        this.operands = operands;
    }

    public int sum() {
        int sum = START_SUM_VALUE;

        for (int operand : operands) {
            sum += operand;
        }

        return sum;
    }
}
