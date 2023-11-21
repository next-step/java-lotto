package calculator.operator;

public interface Operator {

    boolean match(String operator);

    long calculate(long sum, long operand);
}
