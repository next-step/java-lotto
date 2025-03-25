package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    public void 당첨번호와_로또정보를_기반으로_등수정보를_반환한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto firstRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        firstRankLotto.checkLottoResult(winningNumbers);

        Lotto thirdRankLotto = new Lotto(List.of(1, 2, 3, 4, 10, 20));
        thirdRankLotto.checkLottoResult(winningNumbers);

        Lotto noPrizeRankLotto = new Lotto(List.of(1, 2, 11, 23, 33, 38));
        noPrizeRankLotto.checkLottoResult(winningNumbers);

        assertThat(firstRankLotto.getRank()).isEqualTo(Rank.FIRST);
        assertThat(thirdRankLotto.getRank()).isEqualTo(Rank.THIRD);
        assertThat(noPrizeRankLotto.getRank()).isEqualTo(Rank.NO_PRIZE);
    }
}
