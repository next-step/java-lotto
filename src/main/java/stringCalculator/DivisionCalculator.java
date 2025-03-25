package stringCalculator;

public class DivisionCalculator implements CalculatorImplement{
    @Override
    public int calculate(int left, int right) {
        validateRight(right);
        return left / right;
    }

    private void validateRight(int right) {
        if (right == 0) {
            throw new IllegalArgumentException("The right operand cannot be 0.");
        }
    }
}
