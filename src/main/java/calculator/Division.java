package calculator;

public class Division implements Operation {
    @Override
    public int calculate(int preNumber, int postNumber) {
        return preNumber / postNumber;
    }
}
