package step1;

public class AddOperator implements Operator {

    private static AddOperator addCalculator;

    private AddOperator() {}

    public static Operator getInstance() {
        if(addCalculator == null){
            addCalculator = new AddOperator();
        }
        return addCalculator;
    }

    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

}

