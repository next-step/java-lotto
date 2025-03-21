package step1.calc.calculator;


import step1.calc.operand.Operand;
import step1.calc.operator.Operator;

public class Calculator {

    private String[] expressions;

    public Calculator(String[] expressions) {
        if (expressions.length % 2 == 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if (expressions.length < 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        this.expressions = expressions;
    }

    public Operand calculate() {
        Operand result = new Operand(this.expressions[0]);
        for (int i = 1; i < expressions.length; i += 2) {
            Operator operator = new Operator(
                this.expressions[i], result, new Operand(this.expressions[i + 1]));
            result = operator.operate();
        }
        return result;
    }
}
