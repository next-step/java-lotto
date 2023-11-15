package lottosecond.lotto;

import lottosecond.domain.lotto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest(name = "로또 번호가 1보다 작거나 45보다 큰 경우 IllegalArgumentException 을 발생합니다.")
    @ValueSource(ints = {0, 46})
    void invalidNumber(int number) {
        // given
        // when
        // then
        Assertions.assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 범위는 1 ~ 45 범위만 가능합니다.");
    }
}