package lotto.domain.rank;

import lotto.domain.Money;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import lotto.dto.WinLotteryResult;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RankStoreTest {
    @Test
    void increaseHitCount() {
        // given
        final RankHitCountStore calculator = new RankHitCountStore();
        final int hitThreeTimes = Rank.FOURTH.getCountOfMatch();

        // then
        assertThat(calculator.increaseHitCount(hitThreeTimes, true)).isEqualTo(1);
        assertThat(calculator.increaseHitCount(hitThreeTimes, true)).isEqualTo(2);
        assertThat(calculator.increaseHitCount(hitThreeTimes, true)).isEqualTo(3);
    }

    @Test
    void getCount() {
        // given
        final RankHitCountStore calculator = new RankHitCountStore();
        final int hitThreeTimes = Rank.FOURTH.getCountOfMatch();

        // when
        calculator.increaseHitCount(hitThreeTimes, true);

        // then
        assertAll(
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Rank.FOURTH)).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Rank.THIRD)).isEqualTo(0),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Rank.SECOND)).isEqualTo(0),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Rank.FIRST)).isEqualTo(0)
        );
    }

    @Test
    void getCount_return_0() {
        // given
        final Rank nullRank = null;
        final RankHitCountStore calculator = new RankHitCountStore();

        // when
        final int result = calculator.getCount(nullRank);

        // then
        assertThat(result).isZero();
    }

    @Test
    void toWinLotteryResult() {
        // given
        final RankHitCountStore calculator = new RankHitCountStore();
        final int hitThreeTimes = Rank.FOURTH.getCountOfMatch();
        final int hitSixTimes = Rank.FIRST.getCountOfMatch();

        // when
        calculator.increaseHitCount(hitThreeTimes, false);
        calculator.increaseHitCount(hitSixTimes, false);
        final WinLotteryResult result = calculator.toWinLotteryResult();

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