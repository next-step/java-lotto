package stringCalculator;

public class SubtractionCalculator implements CalculatorImplement{
    @Override
    public int calculate(int left, int right) {
        return left - right;
    }
}
