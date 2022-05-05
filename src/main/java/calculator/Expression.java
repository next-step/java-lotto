package calculator;

public class Expression {
    private final Operand firstOperand;
    private final Operator operator;
    private final Operand secondOperand;

    Expression(Operand firstOperand, Operator operator, Operand secondOperand) {
        validateExpressionElement(firstOperand, operator, secondOperand);
        this.firstOperand = firstOperand;
        this.operator = operator;
        this.secondOperand = secondOperand;
    }

    private void validateExpressionElement(Operand firstOperand, Operator operator, Operand secondOperand) {
        if (firstOperand == null || operator == null || secondOperand == null) {
            throw new IllegalArgumentException(String.format(
                    "표현식의 요소들이 null 일 수 없습니다. 입력받은 값 (첫번째 피연산자 : %s, 두번째 피연산자 : %s, 연산자 : %s",
                    firstOperand, secondOperand, operator));
        }
    }

    public int operation() {
        return this.operator.operate(firstOperand.getNumber(), secondOperand.getNumber());
    }
}
