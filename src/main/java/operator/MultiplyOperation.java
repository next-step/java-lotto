package operator;

public class MultiplyOperation implements Operation {
    @Override
    public int calculate(int first, int second) {
        return first * second;
    }
}
