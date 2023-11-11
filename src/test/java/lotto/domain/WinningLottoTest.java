package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    void 당첨로또번호로_구입로또_등수를_알_수_T있다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 5);

        List<LottoRank> actual = winningLotto.winningRank(List.of(lotto));
        List<LottoRank> expected = List.of(LottoRank.FIRST);

        assertThat(actual).isEqualTo(expected);
    }
}
