package stringcalculator.arithmetic;

public class Multiply implements ArithmeticOperation {

    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

}
