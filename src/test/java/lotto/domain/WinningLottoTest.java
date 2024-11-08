package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    void 당첨로또_생성() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(new LottoNumber(1)
        , new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)), new LottoNumber(7));
        assertThat(winningLotto).isEqualTo(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
    }

    @Test
    void 보너스번호_당첨번호_중복_체크() {
        assertThatThrownBy(() -> {
            new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또등수_반환() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        Lotto lotto1 = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.findRank(lotto1)).isEqualTo(LottoRank.FIRST);

        Lotto lotto2 = new Lotto(1, 2, 3, 4, 5, 7);
        assertThat(winningLotto.findRank(lotto2)).isEqualTo(LottoRank.SECOND);

        Lotto lotto3 = new Lotto(1, 2, 3, 4, 5, 8);
        assertThat(winningLotto.findRank(lotto3)).isEqualTo(LottoRank.THIRD);

        Lotto lotto4 = new Lotto(1, 2, 3, 4, 7, 8);
        assertThat(winningLotto.findRank(lotto4)).isEqualTo(LottoRank.FOURTH);

        Lotto lotto5 = new Lotto(1, 2, 3, 7, 8, 9);
        assertThat(winningLotto.findRank(lotto5)).isEqualTo(LottoRank.FIFTH);

        Lotto lotto6 = new Lotto(1, 2, 7, 8, 9, 10);
        assertThat(winningLotto.findRank(lotto6)).isEqualTo(LottoRank.ETC);
    }
}
