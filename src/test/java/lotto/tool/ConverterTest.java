package lotto.tool;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exceptions.InvalidNumberException;

public class ConverterTest {

    @DisplayName("문자열을 숫자로 변환한다.")
    @Test
    void toInteger() {
        assertThat(Converter.toInteger("123")).isEqualTo(123);
    }

    @DisplayName("숫자가 아닌 문자열은 변환에 실패한다.")
    @Test
    void toInteger_InvalidNumber_ExceptionThrown() {
        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(() -> {
            Converter.toInteger("abc");
        });
    }

}
