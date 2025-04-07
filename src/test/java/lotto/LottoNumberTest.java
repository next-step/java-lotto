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
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.getValue()).isEqualTo(1);

        assertThatThrownBy(() -> new LottoNumber(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new LottoNumber(46))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("LottoNumber는 값 기반으로 동등성을 비교한다")
    void shouldCompareEqualityBasedOnValue() {
        LottoNumber number1 = new LottoNumber(1);
        LottoNumber number2 = new LottoNumber(1);
        LottoNumber number3 = new LottoNumber(2);

        assertThat(number1).isEqualTo(number2);
        assertThat(number1).isNotEqualTo(number3);
    }
} 