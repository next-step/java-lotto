
public class Calculator {

    public int calculate(String firstNumberStr, String operator, String lastNumberStr) {
        int firstNumber = Integer.parseInt(firstNumberStr);
        int lastNumber = Integer.parseInt(lastNumberStr);
        return OperatorType.calculate(operator, firstNumber, lastNumber);
    }
}
