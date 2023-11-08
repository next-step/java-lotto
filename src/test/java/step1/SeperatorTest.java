package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Seperator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class SeperatorTest {

    private static final String EMPTY_STRING_ERROR_MESSAGE = "입력값이 공백입니다";

    @Test
    @DisplayName("입력 값이 null인 경우 에러 발생한다")
    public void text_null_error() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Seperator.validate(null);
            }).withMessageMatching(EMPTY_STRING_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("입력 값이 빈 공백인 경우 에러 발생한다")
    public void text_empty_error() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Seperator.validate("");
            }).withMessageMatching(EMPTY_STRING_ERROR_MESSAGE);
    }

}
