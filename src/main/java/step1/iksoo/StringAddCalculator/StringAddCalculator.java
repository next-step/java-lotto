package step1.iksoo.StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private String text;

    public int add(String text) {
        this.text = text;
        if (isNotAddable(this.text)) {
            return 0;
        }

        return addString(this.text);
    }

    private boolean isNotAddable(String text) {
        if (text == null || text.isEmpty() || isContainsMinus(text)) {
            return true;
        }
        return false;
    }

    private boolean isContainsMinus(String text) {
        String[] tokens = makeToken(text);
        boolean isMinus = false;
        for (int i = 0; i < tokens.length; i++) {
            isMinus = isMinus || Integer.parseInt(tokens[i]) < 0 ? true : false;
        }
        return isIllegalArgument(isMinus);
    }

    private boolean isIllegalArgument(boolean isMinus) {
        if (isMinus) {
            throw new IllegalArgumentException("마이너스는 입력할 수 없어요.");
        }
        return false;
    }

    private int addString(String text) {
        String[] tokens = makeToken(text);

        int sumTokens = 0;
        for (int i = 0; i < tokens.length; i++) {
            sumTokens += Integer.parseInt(tokens[i]);
        }

        return sumTokens;
    }

    private String[] makeToken(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }
        return text.split(",|:");
    }
}
