package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Calculator);
    }

    public int calculateText(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        return sumTokens(getTokens(text));
    }

    private boolean isNullOrEmpty(String text) {
        if (text == null) {
            return true;
        }
        if (text.isEmpty()) {
            return true;
        }

        return false;
    }

    private String[] getTokens(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private int sumTokens(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            result += makeValidInteger(token);
        }
        return result;
    }

    private int makeValidInteger(String token){
        int result = Integer.parseInt(token);
        if(result < 0){
            throw new RuntimeException();
        }
        return result;
    }

}
