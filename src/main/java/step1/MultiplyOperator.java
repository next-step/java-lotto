package step1;

public class MultiplyOperator implements Operator {

    private static MultiplyOperator multiplyCalculator;

    private MultiplyOperator() {}

    public static Operator getInstance() {
        if(multiplyCalculator == null){
            multiplyCalculator = new MultiplyOperator();
        }
        return multiplyCalculator;
    }

    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

}

