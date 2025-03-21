package carculator.domain;

public class Calculator {

    public Integer plus(Operand a, Operand b) {
        return a.plus(b);
    }

    public Integer minus(Operand a, Operand b) {
        return a.minus(b);
    }

    public Integer multiply(Operand a, Operand b) {
        return a.multiply(b);
    }

    public Integer divide(Operand a, Operand b) {
        return a.divide(b);
    }
}
