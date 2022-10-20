package stringcalculator.arithmetic;

public class Sub implements ArithmeticOperation {

    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

}
