package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 당첨_갯수_확인() {

        WinningLotto winningLotto = WinningLotto.create(
            Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)));

        assertThat(lotto.matchWinningLotto(winningLotto)).isEqualTo(6);
    }

    @Test
    void 보너스_확인() {
        LottoNumber bonus = new LottoNumber(6);

        Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)));

        assertThat(lotto.matchBonusNumber(bonus)).isTrue();
    }
}
