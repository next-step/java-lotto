package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterTokenizer {
    private final String text;

    public DelimiterTokenizer(String text) {
        this.text = text;
    }

    public List<String> getDelimiters() {
        final List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));
        if(isCustomDelimiter()) {
            String customDelimiter = this.text.substring(
                2,
                this.text.lastIndexOf("\n")
            );
            delimiters.add(customDelimiter);
        }
        return delimiters;
    }

    public boolean isCustomDelimiter() {
        return this.text.startsWith("//");
    }

}
