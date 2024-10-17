package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("LottoNumber를 생성할 때 로또번호가 1이상 45이하인 숫자가 포함되면 예외가 발생한다.")
    void initLottoNumberTest(int number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 로또 번호가 아닙니다.(1이상 45이하 아님)");
    }

    @Test
    @DisplayName("LottoNumber 객체가 값으로 비교가 가능하다.")
    void compareTest() {
        assertThat(LottoNumber.valueOf(1))
                .isLessThan((LottoNumber.valueOf(2)));
    }

    @Test
    @DisplayName("LottoPurchasePrice 객체가 동일성과 동등성을 보장한다.")
    void equalsTest() {
        LottoNumber lottoNumber1 = LottoNumber.valueOf(1);
        LottoNumber lottoNumber2 = LottoNumber.valueOf(1);
        assertThat(lottoNumber1)
                .isEqualTo(lottoNumber2)
                .isSameAs(lottoNumber2);
    }
}