package step1.calc.operand;

import step1.calc.utils.StringUtils;

public class Operand {

    private final int operand;

    public Operand(String operand) {
        this.operand = convert(operand);
    }

    public Operand(int operand) {
        this.operand = operand;
    }

    private int convert(String operand) {
        if (StringUtils.isEmpty(operand)) {
            throw new IllegalArgumentException("operand is empty");
        }
        if (!StringUtils.isNumeric(operand)) {
            throw new IllegalArgumentException("operand is not numeric");
        }
        return Integer.parseInt(operand);
    }

    public int operand() {
        return operand;
    }

}
