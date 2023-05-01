package stringCalculator.strategy;

public class DivideStrategy implements CalculatorStrategy {

    @Override
    public int calculator(int prevOperand, int nextOperand) {
        return prevOperand / nextOperand;
    }
}
