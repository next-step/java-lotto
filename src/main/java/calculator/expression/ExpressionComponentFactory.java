package calculator.expression;

public class ExpressionComponentFactory {
    public static ExpressionComponent valueOf(String value) {
        if ("+".equals(value)){
            return new AddOperator();
        }
        if ("-".equals(value)){
            return new SubtractOperator();
        }
        if ("*".equals(value)){
            return new MultiplyOperator();
        }
        if ("/".equals(value)){
            return new DivideOperator();
        }
        return new Operand(value);
    }


}
