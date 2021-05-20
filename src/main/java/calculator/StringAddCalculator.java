package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String delimiter = ",|:";

    public static int splitAndSum(String inputText) {
        if(inputText == null || inputText.isEmpty())
            return 0;
        if(inputText.length()==1)
            return Integer.parseInt(inputText);

        String[] parsedText = parsingInputText(inputText);
        return sum(parsedText);
    }

    public static String[] parsingInputText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }
        String[] tokens = text.split(delimiter);
        return tokens;
    }

    private static int validatedTokens(String token) {
        if(Integer.parseInt(token) < 0)
            throw new RuntimeException("정수만 입력 가능합니다.");

        return Integer.parseInt(token);
    }

    public static int sum(String[] parsedTexts) {
        int sum=0;
        for (String parsedText : parsedTexts) {
            sum += validatedTokens(parsedText);
        }
        return sum;
    }
}
