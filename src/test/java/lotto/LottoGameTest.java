package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {


    @Nested
    class when_lotto_number_is_matched_on_five{
        @Test
        @DisplayName("bonus 값을 만족하지 않는 경우, 2등에 당첨된다.")
        void bonus_is_not_matched() {
            Money budget = new Money(1000L);
            WiningLotto winLotto = new WiningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
            LottoGame lottoGame = new LottoGame(List.of(
                    new Lotto(Set.of(1, 2, 3, 4, 5, 45))
            ));
            RankMap prizeByRank = lottoGame.getPrizeByRank(winLotto);

            assertThat(prizeByRank).isEqualTo(new RankMap(List.of(new MatchedCount(5))));
        }

        @Test
        @DisplayName("bonus 값을 만족하는 경우, 2등에 당첨된다.")
        void bonus_is_matched() {
            Money budget = new Money(1000L);
            WiningLotto winLotto = new WiningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
            LottoGame lottoGame = new LottoGame(List.of(
                    new Lotto(Set.of(1, 2, 3, 4, 5, 7))
            ));
            RankMap prizeByRank = lottoGame.getPrizeByRank(winLotto);

            assertThat(prizeByRank).isEqualTo(new RankMap(List.of(new MatchedCount(5, true))));
        }
    }
}