package calculator;

public class Plus implements Operation {
    @Override
    public int calculate(int preNumber, int postNumber) {
        return preNumber + postNumber;
    }
}
