public class StringAddCalculator {
    public Integer add(String input) {
        if (isEmptyValue(input)) {
            return 0;
        }
        return null;
    }

    private boolean isEmptyValue(String input) {
        return input == null || input.isEmpty();
    }
}
