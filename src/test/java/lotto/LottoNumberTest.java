package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다")
    void shouldCreateLottoNumber() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(lottoNumber.getValue()).isEqualTo(1);

        assertThatThrownBy(() -> LottoNumber.of(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> LottoNumber.of(46))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("LottoNumber는 같은 값을 가진 경우 동등하다")
    void shouldCompareEqualityBasedOnValue() {
        LottoNumber number1 = LottoNumber.of(1);
        LottoNumber number2 = LottoNumber.of(1);
        LottoNumber number3 = LottoNumber.of(2);

        assertThat(number1).isEqualTo(number2);
        assertThat(number1).isNotEqualTo(number3);

        assertThat(number1).isSameAs(LottoNumber.of(1));
    }
} 