package calculator.domain;

public class AddOperation implements ArithmeticOperation{

    @Override
    public int compute(int a, int b) {
        return a + b;
    }


}
