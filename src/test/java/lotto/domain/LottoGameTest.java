package lotto.domain;

import lotto.domain.lotto.LotteryRank;
import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.wrapper.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.lotto.LotteryRank.*;
import static org.assertj.core.api.Assertions.*;

class LottoGameTest {

    @DisplayName("등수 별 로또 당첨 개수를 확인한다.")
    @Test
    void groupByRankCount() {
        // given
        List<Numbers> numberses = List.of(
            new Numbers(List.of(1, 5, 12, 21, 32, 43)),
            new Numbers(List.of(1, 5, 12, 21, 32, 45)),
            new Numbers(List.of(1, 5, 12, 21, 33, 45)),
            new Numbers(List.of(2, 3, 4, 6, 8, 43))
        );

        LottoGame lottoGame = new LottoGame();
        lottoGame.createLottos(numberses);
        Numbers winningNumbers = new Numbers(List.of(1, 5, 12, 21, 32, 43));

        // when
        RankCountGroup rankCountGroup = lottoGame.groupByRankCount(winningNumbers);

        // then
        assertThat(rankCountGroup.findWinningCountBy(FIRST)).isEqualTo(1);
        assertThat(rankCountGroup.findWinningCountBy(SECOND)).isEqualTo(1);
        assertThat(rankCountGroup.findWinningCountBy(THIRD)).isEqualTo(1);
        assertThat(rankCountGroup.findWinningCountBy(FOURTH)).isEqualTo(0);
    }

    @DisplayName("로또 구매의 총 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        List<Numbers> numberses = List.of(
            new Numbers(List.of(1, 5, 12, 21, 33, 45)),
            new Numbers(List.of(2, 6, 13, 22, 34, 45)),
            new Numbers(List.of(1, 5, 13, 24, 31, 44)),
            new Numbers(List.of(3, 7, 15, 22, 32, 43))
        );

        LottoGame lottoGame = new LottoGame();
        lottoGame.createLottos(numberses);

        Numbers winningNumbers = new Numbers(List.of(1, 5, 12, 21, 32, 43));
        RankCountGroup rankCountGroup = lottoGame.groupByRankCount(winningNumbers);
        // when
        double profitRate = lottoGame.calculateProfitRate(rankCountGroup);

        // then
        assertThat(profitRate).isEqualTo(12.5);
    }
}