package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum SeparatorType {

    DEFAULT(new DefaultSeparator(), "기본 구분자"),
    CUSTOM(new CustomSeparator(), "사용자정의 구분자");

    private final Separator separator;
    private final String description;

    SeparatorType(Separator separator, String description) {
        this.separator = separator;
        this.description = description;
    }

    public static SeparatorType findByInputText(InputText inputText) {
        return Arrays.stream(values())
                .filter(type -> type.separator.getSeparatorPattern()
                        .matcher(inputText.getText())
                        .matches())
                .findAny()
                .orElse(DEFAULT);
    }

    public Separator getSeparator() {
        return separator;
    }

}