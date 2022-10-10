package Lotto;

import java.util.Objects;

public class Operator {
    private static final String ADD = "+";

    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator1 = (Operator) o;
        return Objects.equals(operator, operator1.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "operator='" + operator + '\'' +
                '}';
    }

    int operate(int num1, int num2) {
        int result = 0;
        if (operator.equals(ADD)) {
            result = add(num1, num2);
        }

        return result;
    }

    private int add(int num1, int num2) {
        return num1 + num2;
    }
}
