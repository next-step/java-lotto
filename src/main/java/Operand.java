import java.util.Objects;

public class Operand {
    private final int operand;

    public Operand(String operand) {
        int operandParsedInteger = Integer.parseInt(operand);
        if (this.isNegativeInteger(operandParsedInteger)) {
            throw new RuntimeException("음수는 입력 할 수 없습니다.");
        }
        this.operand = operandParsedInteger;
    }

    public int getOperand() {
        return this.operand;
    }

    private boolean isNegativeInteger(int operand) {
        return operand < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand1 = (Operand) o;
        return Objects.equals(operand, operand1.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }
}
