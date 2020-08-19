package step1.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSpliterTest {
    @DisplayName("음수 나누기")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "", "null", " "})
    public void spliter(String strings) {
        assertThatThrownBy(() -> StringSpliter.spliter(Delimeter.CUSTOM_DELIMETER , strings)).isOfAnyClassIn(RuntimeException.class, NumberFormatException.class);
        assertThatThrownBy(() -> StringSpliter.spliter(Delimeter.DELIMETER , strings)).isOfAnyClassIn(RuntimeException.class, NumberFormatException.class);
    }
}
