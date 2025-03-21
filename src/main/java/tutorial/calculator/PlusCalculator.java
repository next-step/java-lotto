package tutorial.calculator;

public class PlusCalculator implements AbstractCalculator {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
