package Calculator;

import com.sun.deploy.util.StringUtils;

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

    private int makeValidInteger(String token) {
        if (isNotNumberToken(token) || isMinusNumber(token)) {
            throw new RuntimeException();
        }
        return Integer.parseInt(token);
    }

    private boolean isNotNumberToken(String token) {
        return (token.matches("^[0-9]*$")) ? false : true;
    }

    private boolean isMinusNumber(String token) {
        int number = Integer.parseInt(token);
        return (number < 0) ? true : false;
    }

}
