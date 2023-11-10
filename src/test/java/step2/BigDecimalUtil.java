package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step2.exception.EmptyStringException;
import step2.exception.NotNumericException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static step2.util.BigDecimalUtil.stringToBigDecimal;

public class BigDecimalUtil {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열이 null이거나 비었을 경우 에러 발생한다")
    public void validate_null_or_empty(String text) {
        assertThatExceptionOfType(EmptyStringException.class)
            .isThrownBy(() -> {
                stringToBigDecimal(text);
            }).withMessageMatching("입력값이 공백입니다");
    }

    @Test
    @DisplayName("문자열이 숫자로 이루어지지 않을 경우 에러 발생한다")
    public void validate_numeric() {
        assertThatExceptionOfType(NotNumericException.class)
            .isThrownBy(() -> {
                stringToBigDecimal("14000원");
            }).withMessageMatching("입력값이 숫자가 아닙니다");
    }

}
