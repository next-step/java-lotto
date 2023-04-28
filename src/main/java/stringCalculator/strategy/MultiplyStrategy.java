package stringCalculator.strategy;

public class MultiplyStrategy implements CalculatorStrategy {

    @Override
    public int calculator(int prevOperand, int nextOperand) {
        return prevOperand * nextOperand;
    }
}
