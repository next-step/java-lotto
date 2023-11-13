package step1.model.calculate;

public class PlusCalculate implements Calculate {

    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
