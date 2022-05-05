package calculator.domain.Calculation;

public class PlusCalculation implements Calculation {
    public int calculate(int left, int right) {
        return left + right;
    }
}
