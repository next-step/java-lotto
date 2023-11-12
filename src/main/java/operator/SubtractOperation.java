package operator;

public class SubtractOperation implements Operation {
    @Override
    public int calculate(int first, int second) {
        return first - second;
    }
}
