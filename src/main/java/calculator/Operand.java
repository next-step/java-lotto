package calculator;

import org.junit.platform.commons.util.StringUtils;

public class Operand {
    private int operand;

    public Operand(String operand) {
        this.operand = Integer.parseInt(operand);
    }

    public int getValue() {
        return operand;
    }

}
