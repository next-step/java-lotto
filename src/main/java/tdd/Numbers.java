package tdd;

public class Numbers {

    static final int INIT_RESULT_VALUE = 0;

    private String[] numbers;

    Numbers(String[] numberTexts) {
        this.numbers = numberTexts;
    }

    int addAll() {
        int result = INIT_RESULT_VALUE;

        for (String each : numbers) {
            int number = convertToInt(each);
            checkPositiveValidation(number);
            result += number;
        }
        return result;
    }

    private void checkPositiveValidation(int number) {
        if (number < INIT_RESULT_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    private int convertToInt(String numberText) {
        try {
            return Integer.valueOf(numberText);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}
