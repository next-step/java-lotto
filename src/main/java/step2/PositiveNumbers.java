package step2;

public class PositiveNumbers {

    private final PositiveNumber[] positiveNumbers;

    public PositiveNumbers(String[] positiveNumbers) {
        int len = positiveNumbers.length;
        this.positiveNumbers = new PositiveNumber[len];

        for(int i=0; i< positiveNumbers.length; ++i) {
            this.positiveNumbers[i] = new PositiveNumber(positiveNumbers[i]);
        }
    }

    public int length() {
        return positiveNumbers.length;
    }

    public int getIntValue(int idx) {
        return positiveNumbers[idx].intValue();
    }
}
