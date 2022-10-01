package step1;

public class SubstractOperator implements Operator {

    private static SubstractOperator substracCalculator;

    private SubstractOperator() {}

    public static Operator getInstance() {
        if(substracCalculator == null){
            substracCalculator = new SubstractOperator();
        }
        return substracCalculator;
    }

    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

}
