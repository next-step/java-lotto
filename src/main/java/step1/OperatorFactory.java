package step1;

public class OperatorFactory {

    public static Operator getInstance(String operation) {
        if("+".equals(operation)){
            return AddOperator.getInstance();
        }
        if("-".equals(operation)){
            return SubstractOperator.getInstance();
        }
        if("*".equals(operation)){
            return MultiplyOperator.getInstance();
        }
        return DivideOperator.getInstance();
    }
}
