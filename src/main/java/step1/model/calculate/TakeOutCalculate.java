package step1.model.calculate;

public class TakeOutCalculate implements Calculate {

    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
