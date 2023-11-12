package operator;

public class AddOperation implements Operation {
    @Override
    public int calculate(int first, int second) {
        return first + second;
    }
}
