package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 범위 벗어났을 때")
    public void checkLottoRange() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또의 범위를 벗어났습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = 5)
    @DisplayName("로또 번호 가져오는지")
    public void getLottoNumber(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(number);
    }
}
