package model;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {

    private static Map<String, Operator> factory = new HashMap<String, Operator>();

    static {
        factory.put("*", new MultipleOperator());
        factory.put("/", new DivideOperator());
        factory.put("-", new MinusOperator());
        factory.put("+", new PlusOperator());
    }

    public OperatorFactory() {
    }

    public static Operator getOperator(String operator){
        return factory.get(operator);
    }
}
