package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class TextStorage {
    private final String text;
    private final String separator;

    private static final String DEFAULT_SEPARATOR = ",|:";


    public TextStorage(String text, String separator) {
        if (StringUtils.isBlank(text)) {
            text = "0";
        }
        this.separator = separator;
        this.text = text;
    }

    public TextStorage(String text) {
        this(Optional.ofNullable(text).orElse("0"), DEFAULT_SEPARATOR);
    }

    public String getText() {
        return text;
    }

    public String getSeparator() {
        return separator;
    }

    @Override
    public String toString() {
        return "StringObject{" +
                "text='" + text + '\'' +
                ", separator='" + separator + '\'' +
                '}';
    }
}
