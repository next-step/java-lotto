package calculator;

import java.util.HashMap;
import java.util.Map;

public class Operators {

    private static Map<String, Operator> operators = createOperators();

    private Operators() {
    }

    public static Operator create(String value) {
        if (!operators.containsKey(value)) {
            throw new IllegalArgumentException(String.format("Input \"%s\" is not arithmetic character", value));
        }
        return operators.get(value);
    }

    private static Map<String, Operator> createOperators() {
        operators = new HashMap<>();
        operators.put("+", new PlusOperator());
        operators.put("-", new MinusOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivideOperator());
        return operators;
    }

}
