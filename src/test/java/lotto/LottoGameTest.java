package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    /**
     * 수익률 = 총 당첨 금액 / 구입 금액
     */
    @Test
    void statistics_on_matched_count() {
        Money budget = new Money(1000L);
        Lotto winLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        LottoGame lottoGame = new LottoGame(List.of(
                new Lotto(Set.of(1, 3, 5, 14, 22, 45))
        ));
        RankMap prizeByRank = lottoGame.getPrizeByRank(winLotto);

        assertThat(prizeByRank).isEqualTo(new RankMap(List.of(new MatchedCount(3))));
    }
}