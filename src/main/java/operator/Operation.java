package operator;

public interface Operation {
    int calculate(int first, int second);

    static Operation add() {
        return new AddOperation();
    }

    static Operation subtract() {
        return new SubtractOperation();
    }

    static Operation multiply() {
        return new MultiplyOperation();
    }

    static Operation divide() {
        return new DivideOperation();
    }

    static Operation fromSymbol(String symbol) {

        Operator operator = Operator.fromSymbol(symbol);

        if (Operator.ADD.equals(operator)) {
            return add();
        }

        if (Operator.SUBTRACT.equals(operator)) {
            return subtract();
        }

        if (Operator.MULTIPLY.equals(operator)) {
            return multiply();
        }

        if (Operator.DIVIDE.equals(operator)) {
            return divide();
        }

        throw new IllegalArgumentException("유효하지 않은 연산입니다: " + symbol);
    }
}
