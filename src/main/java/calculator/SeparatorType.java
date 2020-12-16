package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum SeparatorType {

    DEFAULT(new DefaultSeparator(), DefaultSeparator.SEPARATOR_PATTERN, "기본 구분자"),
    CUSTOM(new CustomSeparator(), CustomSeparator.SEPARATOR_PATTERN, "사용자정의 구분자");

    private final Separator separator;
    private final Pattern separatorPattern;
    private final String description;

    SeparatorType(Separator separator, Pattern separatorPattern, String description) {
        this.separator = separator;
        this.separatorPattern = separatorPattern;
        this.description = description;
    }

    public static SeparatorType findByInputText(InputText inputText) {
        return Arrays.stream(values())
                .filter(type -> type.separatorPattern
                        .matcher(inputText.getText())
                        .matches())
                .findAny()
                .orElse(DEFAULT);
    }

    public Separator getSeparator() {
        return separator;
    }

}