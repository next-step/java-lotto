package lotto.domain;

import lotto.exceptions.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    @DisplayName("로또 번호의 범위를 벗어나면 InvalidLottoNumberException 예외를 던진다.")
    void invalid_lotto_range(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("1부터 45까지의 로또 번호 객체가 생성되면 InvalidLottoNumberException 예외를 던지지 않는다.")
    void valid_lotto_range(int number) {
        assertThatCode(() -> new LottoNumber(number))
                .doesNotThrowAnyException();
    }
}
