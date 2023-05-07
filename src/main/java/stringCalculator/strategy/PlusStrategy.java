package stringCalculator.strategy;

public class PlusStrategy implements CalculatorStrategy {
    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }
}
