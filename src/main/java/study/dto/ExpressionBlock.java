package study.dto;

import java.util.Objects;
import study.Operator;

public class ExpressionBlock {
    private final Operator operator;
    private final int number;

    private ExpressionBlock(Operator operator, int number){
        this.operator=operator;
        this.number=number;
    }

    public static ExpressionBlock of(Operator operator, int number){
        return new ExpressionBlock(operator, number);
    }

    public Operator getOperator() {
        return operator;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExpressionBlock that = (ExpressionBlock) o;
        return number == that.number && operator == that.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, number);
    }
}
