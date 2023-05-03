package stringCalculator.domain;

public class StringCalculation {
    private Numbers numbers = new Numbers();
    private Operators operators = new Operators();

    private int result = 0;

    public StringCalculation(){
    }

    public StringCalculation(String inputString, int index){
        if (isNumbersPosition(index)) {
            numbers = new Numbers(inputString);
        } else if (!isNumbersPosition(index)) {
            operators = new Operators(inputString);
        }
    }

    public void calculate() {

        int temp = 0;
        setFirstNumber(numbers.getNumbers().get(temp));

        for (String operator : operators.getOperators()) {
            NumericalExpression numericalExpression = NumericalExpression.valueOfNumericalExpression(operator);
            result = numericalExpression.calculate(result, numbers.getNumbers().get(temp + 1));
            temp++;
        }
    }
    private boolean isNumbersPosition(Integer i) {
        return i % 2 != 0;
    }

    private void setFirstNumber(Integer firstNumber) { result = firstNumber; }

    @Override
    public String toString() { return "result :" + result;}
}
