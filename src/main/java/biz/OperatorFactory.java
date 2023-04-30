package biz;

import biz.enums.OperatorEnum;
import biz.function.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {

    private static Map<String, Operator> factory = new HashMap<String, Operator>();

    static {
        factory.put(OperatorEnum.MULTIPLY.getValue(), new MultipleOperator());
        factory.put(OperatorEnum.DIVIDE.getValue(), new DivideOperator());
        factory.put(OperatorEnum.MINUS.getValue(), new MinusOperator());
        factory.put(OperatorEnum.PLUS.getValue(), new PlusOperator());
    }

    public OperatorFactory() {
    }

    public static Operator getOperator(String operator){
        return factory.get(operator);
    }
}
