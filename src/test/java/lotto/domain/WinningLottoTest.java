package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 당첨_변호_생성() {
        WinningLotto winningLotto = WinningLotto.create(
            Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        assertThat(winningLotto.getWinLotto().size()).isEqualTo(6);
    }
}
