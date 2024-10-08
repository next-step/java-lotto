package calculator;

import org.junit.platform.commons.util.StringUtils;

public class Operand {
    private int operand;

    public Operand(String operand) {
        if (StringUtils.isBlank(operand)) {
            throw new IllegalArgumentException("피연산자가 비어 있습니다, 입력값을 확인하십시오");
        }
        this.operand = Integer.parseInt(operand);
    }

    public int getValue() {
        return operand;
    }

}
