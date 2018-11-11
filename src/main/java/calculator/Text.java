package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    public boolean isEmpty() {
        return this.text == null || "".equals(this.text);
    }

    @SuppressWarnings("RegExpSingleCharAlternation")
    public String[] split() {
        final Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        return matcher.find() ? matcher.group(2).split(matcher.group(1)) : this.text.split("(,|:)");
    }

}
