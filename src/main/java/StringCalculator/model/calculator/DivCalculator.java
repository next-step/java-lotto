package StringCalculator.model.calculator;

public class DivCalculator implements Calculator{
    @Override
    public int calculate(int num1, int num2) throws ArithmeticException{
        if (num2 == 0){
            throw new ArithmeticException("divided by zero");
        }
        return num1 / num2;
    }
}
