package stringCalculator;

public class PlusCalculator implements CalculatorImplement{
    @Override
    public int calculate(int left, int right) {
        return left + right;
    }
}
