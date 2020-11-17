package lotto.domain.rank;

import lotto.domain.Money;
import lotto.dto.WinLotteryResult;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankCalculatorTest {
    private List<RankCount> createRankHitCounts() {
        return Collections.unmodifiableList(
                Arrays.stream(Rank.values())
                        .map(RankCount::of)
                        .collect(Collectors.toList())
        );
    }
    @Test
    void increaseHitCount() {
        // given
        final List<RankCount> rankCounts = createRankHitCounts();
        final LottoRankCalculator calculator = new LottoRankCalculator();
        final int hitThreeTimes = Rank.FOURTH.getCountOfMatch();

        // then
        assertThat(calculator.increaseHitCount(rankCounts, hitThreeTimes, true)).isEqualTo(1);
        assertThat(calculator.increaseHitCount(rankCounts, hitThreeTimes, true)).isEqualTo(2);
        assertThat(calculator.increaseHitCount(rankCounts, hitThreeTimes, true)).isEqualTo(3);
    }

    @Test
    void getCount() {
        // given
        final List<RankCount> rankCounts = createRankHitCounts();
        final LottoRankCalculator calculator = new LottoRankCalculator();
        final int hitThreeTimes = Rank.FOURTH.getCountOfMatch();

        // when
        calculator.increaseHitCount(rankCounts, hitThreeTimes, true);

        // then
        assertAll(
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Rank.FOURTH, rankCounts)).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Rank.THIRD, rankCounts)).isEqualTo(0),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Rank.SECOND, rankCounts)).isEqualTo(0),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Rank.FIRST, rankCounts)).isEqualTo(0)
        );
    }

    @Test
    void getCount_return_0() {
        // given
        final Rank nullRank = null;
        final LottoRankCalculator calculator = new LottoRankCalculator();

        // when
        final int result = calculator.getCount(nullRank, createRankHitCounts());

        // then
        assertThat(result).isZero();
    }

    @Test
    void toWinLotteryResult() {
        // given
        final List<RankCount> rankCounts = createRankHitCounts();
        final LottoRankCalculator calculator = new LottoRankCalculator();
        final int hitThreeTimes = Rank.FOURTH.getCountOfMatch();
        final int hitSixTimes = Rank.FIRST.getCountOfMatch();

        // when
        calculator.increaseHitCount(rankCounts, hitThreeTimes, false);
        calculator.increaseHitCount(rankCounts, hitSixTimes, false);
        final WinLotteryResult result = calculator.toWinLotteryResult(rankCounts);

        // then
        final Money hitThreeAndSixPrizeMoney = Rank.FOURTH.getWinningMoney().plus(Rank.FIRST.getWinningMoney());
        assertAll(
                () -> assertThat(result.getFirstRank().getCount()).isOne(),
                () -> assertThat(result.getSecondRank().getCount()).isZero(),
                () -> assertThat(result.getThirdRank().getCount()).isZero(),
                () -> assertThat(result.getFourthRank().getCount()).isOne(),
                () -> assertThat(result.getTotalPrizeMoney()).isEqualTo(hitThreeAndSixPrizeMoney)
        );
    }

}