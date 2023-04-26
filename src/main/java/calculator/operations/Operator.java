package calculator.operations;

@FunctionalInterface
public interface Operator {

    int apply(int a, int b);
}
