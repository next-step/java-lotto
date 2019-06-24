public class StringAddCalculator {
    public int add(String string) {
        if (isInvalidString(string)) {
            return 0;
        }

        return -1;
    }

    private boolean isInvalidString(String string) {
        return string == null || string.equals("");
    }
}
