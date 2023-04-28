package stringCalculator.strategy;

public class MinusStrategy implements CalculatorStrategy {

    @Override
    public int calculator(int prevOperand, int nextOperand) {
        return prevOperand - nextOperand;
    }
}
