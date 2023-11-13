package step1.model.calculate;

public class DivisionCalculate implements Calculate {

    @Override
    public int operate(int firstNumber, int secondNumber) {
        return Math.floorDiv(firstNumber, secondNumber);
    }
}
