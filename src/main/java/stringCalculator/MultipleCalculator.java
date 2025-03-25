package stringCalculator;

public class MultipleCalculator implements CalculatorImplement{
    @Override
    public int calculate(int left, int right) {
        return left * right;
    }
}
