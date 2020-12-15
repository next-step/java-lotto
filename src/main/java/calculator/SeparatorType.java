package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.CustomSeparator.CUSTOM_SEPARATOR_REGEX;

public enum SeparatorType {

    DEFAULT("기본 구분자", new DefaultSeparator()),
    CUSTOM("사용자정의 구분자", new CustomSeparator());

    private final String description;
    private final Separator separator;

    SeparatorType(String description, Separator separator) {
        this.description = description;
        this.separator = separator;
    }

    public static SeparatorType findByInputText(InputText inputText) {
        SeparatorType separatorType = SeparatorType.DEFAULT;
        String text = inputText.getText();
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        if (m.matches()) {
            separatorType = SeparatorType.CUSTOM;
        }
        return separatorType;
    }

    public Separator getSeparator() {
        return separator;
    }

}
