package stringcalculator.model;

public enum Operator {
    SUM, SUBTRACT, MULTIPLY, DIVIDE;

    public int calculate(int operandLeft, int operandRight) {

        if (this.equals(SUM)) {
            return operandLeft + operandRight;
        }
        if (this.equals(SUBTRACT)) {
            return operandLeft - operandRight;
        }
        if (this.equals(MULTIPLY)) {
            return operandLeft * operandRight;
        }
        return operandLeft / operandRight;
    }
}
