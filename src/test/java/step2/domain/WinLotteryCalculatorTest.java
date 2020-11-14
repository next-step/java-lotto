package step2.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import step2.dto.WinLotteryResult;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static step2.domain.WinLotteryCalculator.REWARD_MUST_BE_NOT_NULL;

class WinLotteryCalculatorTest {
    @Test
    void increaseHitCount() {
        // given
        final WinLotteryCalculator calculator = new WinLotteryCalculator();
        final Reward hitThreeTimesReward = Reward.HIT_THREE_TIMES;

        // then
        assertThat(calculator.increaseHitCount(hitThreeTimesReward)).isEqualTo(1);
        assertThat(calculator.increaseHitCount(hitThreeTimesReward)).isEqualTo(2);
        assertThat(calculator.increaseHitCount(hitThreeTimesReward)).isEqualTo(3);
    }

    @Test
    void increaseHitCount_throw_exception() {
        // given
        final Reward nullReward = null;
        final WinLotteryCalculator calculator = new WinLotteryCalculator();

        // when
        final Throwable thrown = catchThrowable(() -> {
            calculator.increaseHitCount(nullReward);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(REWARD_MUST_BE_NOT_NULL);
    }

    @Test
    void getCount() {
        // given
        final WinLotteryCalculator calculator = new WinLotteryCalculator();
        final Reward hitThreeTimesReward = Reward.HIT_THREE_TIMES;

        // when
        calculator.increaseHitCount(hitThreeTimesReward);

        // then
        assertAll(
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Reward.HIT_THREE_TIMES)).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Reward.HIT_FOUR_TIMES)).isEqualTo(0),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Reward.HIT_FIVE_TIMES)).isEqualTo(0),
                () -> AssertionsForClassTypes.assertThat(calculator.getCount(Reward.HIT_SIX_TIMES)).isEqualTo(0)
        );
    }

    @Test
    void getCount_throw_exception() {
        // given
        final Reward nullReward = null;
        final WinLotteryCalculator calculator = new WinLotteryCalculator();

        // when
        final Throwable thrown = catchThrowable(() -> {
            calculator.getCount(nullReward);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(REWARD_MUST_BE_NOT_NULL);
    }

    @Test
    void toWinLotteryResult() {
        // given
        final WinLotteryCalculator calculator = new WinLotteryCalculator();

        // when
        calculator.increaseHitCount(Reward.HIT_THREE_TIMES);
        calculator.increaseHitCount(Reward.HIT_SIX_TIMES);
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