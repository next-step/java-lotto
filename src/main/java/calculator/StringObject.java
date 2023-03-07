package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class StringObject {
    private String text;
    private String separator;

    private static final String DEFAULT_SEPARATOR = ",|:";

    public StringObject(String text, String separator){
        if(StringUtils.isBlank(text)){
            text = "0";
        }
        this.separator =  separator;
        this.text = text;
    }
    public StringObject(String text){
        this(  Optional.ofNullable(text).orElse("0") , DEFAULT_SEPARATOR);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public String toString() {
        return "StringObject{" +
                "text='" + text + '\'' +
                ", separator='" + separator + '\'' +
                '}';
    }
}
