package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    void createTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNo = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNo);

        assertThat(winningLotto).isNotNull();
    }

    @Test
    void calculateRankTest() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNo = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNo);

        // when
        Lotto lottoTicket = new Lotto(Arrays.asList(1, 2, 3, 7, 5, 6));

        // then
        assertThat(winningLotto.calculateRank(lottoTicket)).isEqualTo(Rank.SECOND);
    }
}
