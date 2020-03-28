package caculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Caculator {
    private static final int NULL_EMPTY_VALUE = 0;
    private static final int NORMAL_VALUE = 1;
    private static final String SPLIT_TEXT = ",|:";
    private static final String MINUS_OPERATOR = "-";

    private String inputText;

    public Caculator() {
    }

    public Caculator(String inputText) {
        this.inputText = inputText;
    }

    public int validateInputText(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return NULL_EMPTY_VALUE;
        }

        return NORMAL_VALUE;
    }

    private int oneNumberInputText(String inputText) {
        return Integer.parseInt(inputText);
    }

    public int splitNumberAndCharater(String inputText) {
        String[] numbers = getNumbers(inputText, SPLIT_TEXT);
        return sumNumbers(numbers);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += oneNumberInputText(numbers[i]);
        }
        return sum;
    }

    private String[] getNumbers(String inputText, String splitText) {
        return inputText.split(splitText);
    }

    public int splitNumberAndCustomSeparator(String inputText) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (!matcher.find()) { return 0; }

        String[] numbers = getNumbers(matcher.group(2), matcher.group(1));
        return sumNumbers(numbers);

    }

    public void inputTextIsNegative(String inputText) {
        if (inputText.contains(MINUS_OPERATOR)) {
            throw new RuntimeException("음수가 들어 올 수 없습니다.");
        }

    }
}
