package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoNumberTest {
    @DisplayName("범위에 맞지 않는 숫자일 경우 예외를 던진다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void LottoNumberNotValid(int number) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new LottoNumber(number));
    }
}