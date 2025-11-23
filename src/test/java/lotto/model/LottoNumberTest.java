package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다.")
    @ValueSource(ints = {1, 45})
    void validLottoNumberTest(int number) {
        assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(number));
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @ValueSource(ints = {0, 46})
    void invalidLottoNumberTest(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}