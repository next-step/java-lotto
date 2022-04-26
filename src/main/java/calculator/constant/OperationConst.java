package calculator.constant;

import calculator.domain.operation.*;
import calculator.exception.InvalidSignException;

import java.util.Arrays;

public enum OperationConst {

    ADD("+", new AddOperation())
    , MINUS("-", new MinusOperation())
    , DIVISION("/", new DivideOperation())
    , MULTIPLICATION("*", new MultiplyOperation());

    private String sign;
    private Operation operation;

    OperationConst(String sign, Operation operation) {
        this.sign = sign;
        this.operation = operation;
    }

    public static OperationConst findBySign(String sign) {
        return Arrays.asList(OperationConst.values())
                .stream()
                .filter(operationConst -> operationConst.sign.equals(sign))
                .findAny()
                .orElseThrow(InvalidSignException::new);
    }

    public Operation operation() {
        return this.operation;
    }
}
