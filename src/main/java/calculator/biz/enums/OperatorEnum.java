package calculator.biz.enums;

import calculator.biz.function.*;

import java.util.Arrays;

public enum OperatorEnum {

    PLUS("+", new PlusOperator()),
    MINUS("-", new MinusOperator()),
    DIVIDE("/", new DivideOperator()),
    MULTIPLY("*", new MultipleOperator());

    private String value;
    private Operator operator;

    OperatorEnum(String value, Operator operator) {
        this.value = value;
        this.operator = operator;
    }


    public String getValue() {
        return value;
    }

    public Operator getOperator() {
        return operator;
    }

    public static Operator findOperator(String value){
        return Arrays.stream(OperatorEnum.values())
                .filter(operator -> operator.getValue().equals(value))
                .findAny().orElse(null).getOperator();
    }
}
