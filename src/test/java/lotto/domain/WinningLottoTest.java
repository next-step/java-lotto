package lotto.domain;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    void winningLottoGenerateTest() {
        assertThatIllegalStateException().isThrownBy(() -> new WinningLotto("1, 2, 3, 4, 5"));
    }

    @Test
    void contains() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        LottoNumber lottoNumber1 = new LottoNumber(6);
        LottoNumber lottoNumber2 = new LottoNumber(7);

        assertThat(winningLotto.contains(lottoNumber1)).isTrue();
        assertThat(winningLotto.contains(lottoNumber2)).isFalse();
    }
}