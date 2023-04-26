package calculcator;

public class OperatorFactory {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String STAR = "*";
    public static final String SLASH = "/";

    public static Operator create(String operator){
        if(operator.equals(PLUS)){
            return Operator.ADDITION;
        }
        if (operator.equals(MINUS)) {
            return Operator.SUBTRACTION;
        }
        if (operator.equals(STAR)){
            return Operator.MULTIPLICATION;
        }
        if (operator.equals(SLASH)){
            return Operator.DIVISION;
        }
        throw new IllegalArgumentException("유효한 사칙연산 부호가 아닙니다");
    }

}
