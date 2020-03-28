package caculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Caculator {

    private static final String SPLIT_TEXT = ",|:";
    private static final String CUSTOM_SPLIT_REGEX = "//(.)\n(.*)";

    private String inputText;

    public Caculator() {
    }

    public Caculator(String inputText) {
        this.inputText = inputText;
    }

    private int oneNumberInputText(String inputText) {
        return Integer.parseInt(inputText);
    }

    public int splitNumberAndCharacter(String inputText) {
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
        Matcher matcher = Pattern.compile(CUSTOM_SPLIT_REGEX).matcher(inputText);
        if (!matcher.find()) { return 0; }

        String[] numbers = getNumbers(matcher.group(2), matcher.group(1));
        return sumNumbers(numbers);

    }

}
