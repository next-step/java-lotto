package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * ValidationUtil 클래스의 유효성 검증 기능 테스트
 */
public class ValidationUtilTest {

    @ParameterizedTest
    @CsvSource(value = {"200000000000,true", "-200000000000,true", "1.1,false", "'',false", ",false", "' ',false", "a,false"})
    @DisplayName("입력된 문자열이 숫자인지 확인")
    void isLongNumber(String numberText, boolean result) {
        // then
        assertThat(ValidationUtil.isLongNumber(numberText)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "-1,true", "1.1,false", "'',false", ",false", "' ',false", "a,false", "200000000000,false", "-200000000000,false"})
    @DisplayName("입력된 문자열이 숫자인지 확인")
    void isIntegerNumber(String numberText, boolean result) {
        // then
        assertThat(ValidationUtil.isIntegerNumber(numberText)).isEqualTo(result);
    }
}
