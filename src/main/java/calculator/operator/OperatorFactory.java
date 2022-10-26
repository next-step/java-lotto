package calculator.operator;

public class OperatorFactory {

    public static Operator getOperator(String operatorStr) {
        switch (operatorStr) {
            case "+":
                return AddOperator.getOperator();
            case "-":
                return SubtractOperator.getOperator();
            case "*":
                return MultiplyOperator.getOperator();
            case "/":
                return DivideOperator.getOperator();
            default:
                throw new IllegalArgumentException("허용되지 않은 연산 기호가 포함되어 있습니다");
        }
    }
}
