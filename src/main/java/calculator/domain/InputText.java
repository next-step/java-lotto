package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputText {
    private final String REGEX = "//(.)\n(.*)";
    String inputText = null;

    public InputText(String inputText) {
        if (inputText == null || "".equals(inputText.trim())) {
            inputText = "0";
        }
        this.inputText = inputText;
    }


    public String[] splitInputText() {
        Matcher m = Pattern.compile(REGEX).matcher(inputText);
        return m.find() ? m.group(2).split(m.group(1)) : inputText.split(",|:");
    }
}
