package stringCalculator.strategy;

public class MultiplyStrategy implements CalculatorStrategy {

    @Override
    public int applyAsInt(int left, int right) {
        return left * right;
    }
}
