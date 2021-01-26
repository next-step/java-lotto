package calculator;

public class StringCalculator {
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final String DEFAULT_DELIMITER = ",|:";

    public int add(String text) {
        if (checkNotValidInput(text)) {
            return 0;
        }

        String[] numbers = splitText(text);

        return sum(numbers);
    }

    private String[] splitText(String text) {
        return text.split(",|:");
    }

    private Boolean checkNotValidInput(String text) {
        if (text == null || "".equals(text)) {
            return true;
        }
        return false;
    }

    private int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}
