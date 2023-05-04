package stringCalculator.strategy;

public class DivideStrategy implements CalculatorStrategy {

    @Override
    public int applyAsInt(int left, int right) {

        if(right == 0) {
            throw new ArithmeticException("0 으로는 나눌 수 없습니다.");
        }

        return left / right;
    }
}
