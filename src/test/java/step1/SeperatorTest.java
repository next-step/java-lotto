package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Seperator;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class SeperatorTest {

    private static final String EMPTY_STRING_ERROR_MESSAGE = "입력값이 공백입니다";

    @Test
    @DisplayName("입력 값이 null인 경우 에러 발생한다")
    public void text_null_error() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new Seperator(null);
            }).withMessageMatching(EMPTY_STRING_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("입력 값이 빈 공백인 경우 에러 발생한다")
    public void text_empty_error() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new Seperator("");
            }).withMessageMatching(EMPTY_STRING_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("문자열에서 숫자를 뽑아낼 수 있다")
    public void extract_numbers() {
        String text = "12 + 134 * 45 / 2000 + 12";
        assertThat(new Seperator(text).numbers()).isEqualTo(Arrays.asList(12, 134, 45, 2000, 12));
    }

    @Test
    @DisplayName("문자열에서 연산자를 뽑아낼 수 있다")
    public void extract_operators() {
        String text = "2 + 3 * 4 / 2 + 1 * 1";
        assertThat(new Seperator(text).operators()).isEqualTo(Arrays.asList("+", "*", "/", "+", "*"));
    }

}
