package step1.operator;

public class OperatorFactory {
    public static Operator createOperator(String operator) {
        if(operator.equals("+")){
            return new AddOperator();
        };

        if (operator.equals("-")) {
            return new MinusOperator();
        };

        if (operator.equals("*")) {
            return new MultiplyOperator();
        };

        if (operator.equals("/")) {
            return new DivideOperator();
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
}
