package calculator;

import org.junit.platform.commons.util.StringUtils;

public class Operands {
    private int operand1;
    private int operand2;

    public Operands(String operand1, String operand2) {
        if (StringUtils.isBlank(operand1) || StringUtils.isBlank(operand2)) {
            throw new IllegalArgumentException("피연산자가 비어 있습니다, 입력값을 확인하십시오");
        }
        this.operand1 = Integer.parseInt(operand1);
        this.operand2 = Integer.parseInt(operand2);
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }
}
