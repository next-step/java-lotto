package stringcalculator;

@FunctionalInterface
public interface Operator {
    int apply(int num1, int num2);
}
