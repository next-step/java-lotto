package stringcalculator;

@FunctionalInterface
public interface Operator {
    public int calculate(int a, int b);
}
