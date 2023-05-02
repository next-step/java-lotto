package stringCalculator.strategy;

public class DivideStrategy implements CalculatorStrategy {

    @Override
    public int applyAsInt(int left, int right) {
        return left / right;
    }
}
