package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @DisplayName("LottoNumber equals 테스트")
    @Test
    void compare() {
        LottoNumber lottoNumber = LottoNumber.of(3);

        assertThat(lottoNumber).isEqualTo(LottoNumber.of(3));
    }

    @DisplayName("LottoNumber of 메소드 - 정상적인 로또 번호 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "30", "45"})
    void of(int number) {
        assertThatCode(() -> LottoNumber.of(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("LottoNumber of 메소드 - 범위 벗어난 로또 번호 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "47", "100"})
    void of_error_test(int number) {

        String expectedMessage = LottoExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;

        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
}
