public class StringCalculator {

    private static final int ZERO = 0;
    private static final String COMMA = ",";

    public int calculate(final String value) {
        if (isEmpty(value)) {
            return ZERO;
        }

        String[] twoNumbers = value.split(COMMA);
        for (String number : twoNumbers) {
            isNegative(number);
        }

        int sum = 0;
        for (String twoNumber : twoNumbers) {
            sum += toInt(twoNumber);
        }
        return sum;
    }

    private boolean isEmpty(final String str) {
        return (str == null || str.isEmpty());
    }

    private void isNegative(final String value) {
        if (Integer.parseInt(value) < ZERO) {
            throw new RuntimeException();
        }
    }

    private int toInt(final String number) {
        return Integer.parseInt(number);
    }
}
