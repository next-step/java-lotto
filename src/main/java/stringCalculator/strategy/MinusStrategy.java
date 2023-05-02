package stringCalculator.strategy;

public class MinusStrategy implements CalculatorStrategy {

    @Override
    public int applyAsInt(int left, int right) {
        return left - right;
    }
}
