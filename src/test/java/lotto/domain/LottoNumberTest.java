package lotto.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


class LottoNumberTest {
    @DisplayName("숫자가 아닌 값이거나 바뀐 숫자가 범위에 맞지 않는 경우 예외를 던지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"0", "NOTNUM"})
    void LottoNumberNotNumber(String string) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new LottoNumber(string));
    }

    @DisplayName("범위에 맞지 않는 숫자일 경우 예외를 던지는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void LottoNumberNotInRange(int number) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new LottoNumber(number));
    }
}