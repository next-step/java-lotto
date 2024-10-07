package stringcalculator.domain.operator;

import stringcalculator.exception.StringCalculatorIllegalArgumentException;
import stringcalculator.util.StringUtil;

public class OperandParser {
    private OperandParser() {
    }

    public static int parse(String operand) {
        if(StringUtil.isBlank(operand)) {
            throw new StringCalculatorIllegalArgumentException("피 연산자가 비어있습니다.");
        }

        try {
            return Integer.parseInt(operand);
        } catch(NumberFormatException e) {
            throw new StringCalculatorIllegalArgumentException("피 연산자를 숫자로 변환할 수 없습니다.");
        }

    }
}
