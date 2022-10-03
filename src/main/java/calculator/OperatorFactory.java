package calculator;

public class OperatorFactory {

    public static Operator getInstance(String operation) {
        return OperatorEnum.getOperator(operation);
    }
}
