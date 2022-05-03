package stringcalculator;

@FunctionalInterface
public interface Operator {
    int calculate(int a, int b);
}
