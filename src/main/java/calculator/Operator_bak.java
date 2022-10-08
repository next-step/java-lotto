package calculator;

import java.util.Objects;

public class Operator_bak {
    public static final String ERR_MSG_OPERATOR = "사칙연산 기호가 아닙니다";
    private String op;

    public Operator_bak(String op) {
        if (!(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))) {
            throw new IllegalArgumentException(ERR_MSG_OPERATOR);
        }
        this.op = op;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator_bak operator = (Operator_bak) o;
        return Objects.equals(op, operator.op);
    }

    @Override
    public int hashCode() {
        return Objects.hash(op);
    }
}
