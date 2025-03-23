package step1.calculator.model;

public class DivideModule implements CalculatorModule {

    @Override
    public int calculate(int x, int y) {
        return x / y;
    }

}
