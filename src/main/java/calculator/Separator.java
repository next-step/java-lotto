package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public interface Separator {
    PositiveNumbers split(InputText inputText);
    Pattern getSeparatorPattern();
    default PositiveNumber[] getPositiveNumberArray(String[] inputTexts) {
        return Arrays.stream(inputTexts)
                .map(PositiveNumber::new)
                .toArray(PositiveNumber[]::new);
    }
}
