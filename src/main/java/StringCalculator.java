public class StringCalculator {

    private static final int ZERO = 0;

    public int calculate(final String value) {
        if (isEmpty(value)) {
            return ZERO;
        }
        isNegative(value);
        return Integer.parseInt(value);
    }

    private boolean isEmpty(final String str) {
        return (str == null || str.isEmpty());
    }

    private void isNegative(final String value) {
        if (Integer.parseInt(value) < ZERO) {
            throw new RuntimeException();
        }
    }
}
