package calculator.domain.operator;

public interface Operator {
    int operate(int a, int b);
    String symbol();
}
