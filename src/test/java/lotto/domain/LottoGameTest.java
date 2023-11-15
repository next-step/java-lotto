package lotto.domain;

import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.lotto.wrapper.LottoNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.lotto.LotteryRank.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @DisplayName("등수 별 로또 당첨 개수를 확인한다.")
    @Test
    void groupByRankCount() {
        // given
        List<LottoNumbers> lottoNumberses = List.of(
            new LottoNumbers(List.of(1, 5, 12, 21, 32, 43)),
            new LottoNumbers(List.of(1, 5, 12, 21, 32, 45)),
            new LottoNumbers(List.of(1, 5, 12, 21, 33, 45)),
            new LottoNumbers(List.of(2, 3, 4, 6, 8, 43))
        );

        LottoGame lottoGame = new LottoGame();
        lottoGame.createLottos(lottoNumberses);
        LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 5, 12, 21, 32, 43));

        // when
        RankCountGroup rankCountGroup = lottoGame.groupByRankCount(winningNumbers);

        // then
        assertAll(
            () -> assertEquals(rankCountGroup.findWinningCountBy(FIRST), 1),
            () -> assertEquals(rankCountGroup.findWinningCountBy(SECOND), 1),
            () -> assertEquals(rankCountGroup.findWinningCountBy(THIRD), 1),
            () -> assertEquals(rankCountGroup.findWinningCountBy(FOURTH), 0)
        );
    }

    @DisplayName("로또 구매의 총 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        List<LottoNumbers> lottoNumberses = List.of(
            new LottoNumbers(List.of(1, 5, 12, 21, 33, 45)),
            new LottoNumbers(List.of(2, 6, 13, 22, 34, 45)),
            new LottoNumbers(List.of(1, 5, 13, 24, 31, 44)),
            new LottoNumbers(List.of(3, 7, 15, 22, 32, 43))
        );

        LottoGame lottoGame = new LottoGame();
        lottoGame.createLottos(lottoNumberses);

        LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 5, 12, 21, 32, 43));
        RankCountGroup rankCountGroup = lottoGame.groupByRankCount(winningNumbers);

        // when
        double profitRate = lottoGame.calculateProfitRate(rankCountGroup);

        // then
        assertThat(profitRate).isEqualTo(12.5);
    }
}