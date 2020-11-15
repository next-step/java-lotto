package step2.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import step2.dto.WinLotteryResult;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RewardStoreTest {
    @Test
    void increaseHitCount() {
        // given
        final RewardStore calculator = new RewardStore();
        final int hitThreeTimes = Reward.HIT_THREE_TIMES.getHitTimes();

        // then
        assertThat(calculator.increaseHitCount(hitThreeTimes)).isEqualTo(1);
        assertThat(calculator.increaseHitCount(hitThreeTimes)).isEqualTo(2);
        assertThat(calculator.increaseHitCount(hitThreeTimes)).isEqualTo(3);
    }

    @Test
    void getCount() {
        // given
        final RewardStore calculator = new RewardStore();
        final int hitThreeTimes = Reward.HIT_THREE_TIMES.getHitTimes();

        // when
        calculator.increaseHitCount(hitThreeTimes);

        // then
        assertAll(
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Reward.HIT_THREE_TIMES)).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Reward.HIT_FOUR_TIMES)).isEqualTo(0),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Reward.HIT_FIVE_TIMES)).isEqualTo(0),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Reward.HIT_SIX_TIMES)).isEqualTo(0)
        );
    }

    @Test
    void getCount_return_0() {
        // given
        final Reward nullReward = null;
        final RewardStore calculator = new RewardStore();

        // when
        final int result = calculator.getCount(nullReward);

        // then
        assertThat(result).isZero();
    }

    @Test
    void toWinLotteryResult() {
        // given
        final RewardStore calculator = new RewardStore();
        final int hitThreeTimes = Reward.HIT_THREE_TIMES.getHitTimes();
        final int hitSixTimes = Reward.HIT_SIX_TIMES.getHitTimes();

        // when
        calculator.increaseHitCount(hitThreeTimes);
        calculator.increaseHitCount(hitSixTimes);
        final WinLotteryResult result = calculator.toWinLotteryResult();

        // then
        final Money hitThreeAndSixPrizeMoney = Reward.HIT_THREE_TIMES.getMoney().plus(Reward.HIT_SIX_TIMES.getMoney());
        assertAll(
                () -> assertThat(result.getHitThreeTimes().getCount()).isOne(),
                () -> assertThat(result.getHitFourTimes().getCount()).isZero(),
                () -> assertThat(result.getHitFiveTimes().getCount()).isZero(),
                () -> assertThat(result.getHitSixTimes().getCount()).isOne(),
                () -> assertThat(result.getTotalPrizeMoney()).isEqualTo(hitThreeAndSixPrizeMoney)
        );
    }
}