package calculator.biz.function;

public class MultipleOperator implements Operator{
    @Override
    public int getResult(int v1, int v2) {
        return v1*v2;
    }
}