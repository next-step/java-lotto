package stringcalculator.arithmetic;

public class Add implements ArithmeticOperation {

    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

}
