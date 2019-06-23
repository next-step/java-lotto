package stringAddCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int add(String inputText) {
        if (isNullOrBlank(inputText)) {
            return 0;
        }

        String delimiter = getDelimiter(inputText);
        String tokens = getTokens(inputText);
        String[] StringNumbers = splitString(tokens, delimiter);
        int[] intNumbers = arrayStringToArrayInt(StringNumbers);

        return excuteAdd(intNumbers);
    }

    Matcher getMatcher(String inputText) {
        return Pattern.compile("//(.)\n(.*)").matcher(inputText);
    }

    String getTokens(String inputText) {
        Matcher m = getMatcher(inputText);
        if (m.find()) {
            return m.group(2);
        }
        return inputText;
    }

    String getDelimiter(String inputText) {
        Matcher m = getMatcher(inputText);
        if (m.find()) {
            return m.group(1);
        }
        return ",|:";
    }

    int excuteAdd(int[] intNumbers) {
        return Arrays.stream(intNumbers).sum();
    }

    int[] arrayStringToArrayInt(String[] stringNumbers) {
        return Arrays.stream(stringNumbers).mapToInt(Integer::parseInt).filter(this::isMinusValue).toArray();
    }

    String[] splitString(String inputText, String delimiter) {
        return inputText.split( delimiter);
    }

    boolean isNullOrBlank(String inputText) {
        return inputText == null || inputText.isBlank();
    }

    public boolean isMinusValue(int number) {
        if(number < 0){
            throw new IllegalArgumentException();
        }
        return true;
    }
}
