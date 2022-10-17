package calculator.operator;

import java.util.HashMap;

public class OperatorFactory {

    private final HashMap<OperatorType, Calculable> operatorMap = new HashMap<>();

    public OperatorFactory() {

        operatorMap.put(OperatorType.ADD, new AddOperator());
        operatorMap.put(OperatorType.MINUS, new MinusOperator());
        operatorMap.put(OperatorType.MULTIPLY, new MultiplyOperator());
        operatorMap.put(OperatorType.DIVIDE, new DivideOperator());

    }

    public Calculable getOperator(OperatorType type) {
        return operatorMap.get(type);
    }
}
