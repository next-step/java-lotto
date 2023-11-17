package lotto.domain;

import lotto.domain.lotto.wrapper.WinningNumber;
import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.lotto.wrapper.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static lotto.domain.lotto.LotteryRank.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @DisplayName("등수 별 로또 당첨 개수를 확인한다.")
    @Test
    void groupByRankCount() {
        // given
        List<LottoNumbers> lottoNumberses = List.of(
            new LottoNumbers(Set.of(1, 5, 12, 21, 32, 43)),
            new LottoNumbers(Set.of(1, 5, 12, 21, 32, 42)),
            new LottoNumbers(Set.of(1, 5, 12, 21, 33, 45)),
            new LottoNumbers(Set.of(2, 3, 4, 6, 8, 43))
        );
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 5, 12, 21, 32, 43), 45);
        LottoGame lottoGame = new LottoGame(lottoNumberses, winningNumber);

        // when
        RankCountGroup rankCountGroup = lottoGame.groupByRankCount();

        // then
        assertAll(
            () -> assertEquals(1, rankCountGroup.findWinningCountBy(FIRST)),
            () -> assertEquals(1, rankCountGroup.findWinningCountBy(SECOND)),
            () -> assertEquals(1, rankCountGroup.findWinningCountBy(THIRD)),
            () -> assertEquals(0, rankCountGroup.findWinningCountBy(FOURTH))
        );
    }

    @DisplayName("로또 구매의 총 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        List<LottoNumbers> lottoNumberses = List.of(
            new LottoNumbers(Set.of(1, 5, 12, 21, 33, 45)),
            new LottoNumbers(Set.of(2, 6, 13, 22, 34, 45)),
            new LottoNumbers(Set.of(1, 5, 13, 24, 31, 44)),
            new LottoNumbers(Set.of(3, 7, 15, 22, 32, 43))
        );
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 5, 12, 21, 32, 43), 45);
        LottoGame lottoGame = new LottoGame(lottoNumberses, winningNumber);

        RankCountGroup rankCountGroup = lottoGame.groupByRankCount();

        // when
        double profitRate = lottoGame.calculateProfitRate(rankCountGroup);

        // then
        assertThat(profitRate).isEqualTo(12.5);
    }
}