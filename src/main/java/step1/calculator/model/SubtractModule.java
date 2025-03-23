package step1.calculator.model;

public class SubtractModule implements CalculatorModule {

    @Override
    public int calculate(int x, int y) {
        return x - y;
    }

}
