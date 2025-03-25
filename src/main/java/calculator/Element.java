package calculator;

public class Element {
    private final Operator operator;
    private final int operand;

    public Element(Operator operator, int operand) {
        if (operator == null) {
            throw new IllegalArgumentException("연산자가 없습니다.");
        }
        this.operator = operator;
        this.operand = operand;
    }

    public Operator getOperator() {
        return operator;
    }

    public int getOperand() {
        return operand;
    }

    public int calculate(int operand) {
        return this.operator.calculate(operand, this.operand);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Element element = (Element) o;
        return operand == element.operand && operator == element.operator;
    }

    @Override
    public int hashCode() {
        int result = operator.hashCode();
        result = 31 * result + operand;
        return result;
    }
}
