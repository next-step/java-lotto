package step1.iksoo.StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private String text;

    public void StrngAddCalculator(String text) {
        this.text = text;
    }

    public int add(String text) throws Exception {
        this.text = text;

        if (isEmpty()) {
            return 0;
        }

        if (isCustomDelimiter()) {
            return addStringCustom();
        }

        return addString();
    }

    private boolean isEmpty() {
        if (this.text == null || this.text.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isCustomDelimiter() {
        if (this.text.contains("//") && this.text.contains("\n")) {
            return true;
        }
        return false;
    }

    private int addStringCustom() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return addStringArray(tokens);
        }
        return -1;
    }

    private int addString() throws Exception {
        String[] tokens = this.text.split(",|:");
        if (isStringMinus(tokens)) {
            throw new IllegalArgumentException();
        }
        return addStringArray(tokens);
    }

    private boolean isStringMinus(String[] tokens) throws Exception {
        for (int i = 0; i < tokens.length; i++) {
            if (Integer.parseInt(tokens[i]) < 0)
                return true;
        }
        return false;
    }

    private int addStringArray(String[] tokens) {
        int sumTokens = 0;
        for (int i = 0; i < tokens.length; i++) {
            sumTokens += Integer.parseInt(tokens[i]);
        }
        return sumTokens;
    }
}
