package stringCalculator.strategy;

public class PlusStrategy implements CalculatorStrategy {

    @Override
    public int calculator(int prevOperand, int nextOperand) {
        return prevOperand + nextOperand;
    }
}
