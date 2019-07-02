package camp.nextstep.edu.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLotteryTest {
    @Test
    @DisplayName("당첨 로또가 잘 생성되는지")
    void test() {
        // given
        final Lottery lottery = this.createLottery(1, 2, 3, 4, 5, 6);
        final LotteryNumber bonusNumber = LotteryNumber.from(7);
        // when
        final WinningLottery actual = WinningLottery.of(lottery, bonusNumber);
        // then
        assertThat(actual).isInstanceOf(WinningLottery.class);
    }

    @Test
    @DisplayName("당첨 로또에 사용된 번호를 보너스 번호로 입력하는 경우 IllegalArgumentException 발생시켜야함")
    void validation() {
        // given
        final Lottery lottery = this.createLottery(1, 2, 3, 4, 5, 6);
        final LotteryNumber bonusNumber = LotteryNumber.from(1);
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottery.of(lottery, bonusNumber))
                // then
                .withMessageContaining("'bonusNumber' must not be contained in numbers of winningLottery");
    }

    @Test
    @DisplayName("아무 번호도 일치하지 않는 경우 UNKNOWN 을 반환해야함")
    void resolveReward0() {
        // given
        final WinningLottery winningLottery = this.createWinningLottery(7, 1, 2, 3, 4, 5, 6);
        final Lottery lottery = this.createLottery(11, 12, 13, 14, 15, 16);
        // when
        final RewardType actual = winningLottery.resolveReward(lottery);
        // then
        assertThat(actual).isEqualByComparingTo(RewardType.UNKNOWN);
    }

    @Test
    @DisplayName("1개 번호만 일치하는 경우 UNKNOWN 을 반환해야함")
    void resolveReward1() {
        // given
        final WinningLottery winningLottery = this.createWinningLottery(7, 1, 2, 3, 4, 5, 6);
        final Lottery lottery = this.createLottery(1, 12, 13, 14, 15, 16);
        // when
        final RewardType actual = winningLottery.resolveReward(lottery);
        // then
        assertThat(actual).isEqualByComparingTo(RewardType.UNKNOWN);
    }

    @Test
    @DisplayName("2개 번호만 일치하는 경우 UNKNOWN 을 반환해야함")
    void resolveReward2() {
        // given
        final WinningLottery winningLottery = this.createWinningLottery(7, 1, 2, 3, 4, 5, 6);
        final Lottery lottery = this.createLottery(1, 2, 13, 14, 15, 16);
        // when
        final RewardType actual = winningLottery.resolveReward(lottery);
        // then
        assertThat(actual).isEqualByComparingTo(RewardType.UNKNOWN);
    }

    @Test
    @DisplayName("3개 번호만 일치하는 경우 5등을 반환해야함")
    void resolveReward3() {
        // given
        final WinningLottery winningLottery = this.createWinningLottery(7, 1, 2, 3, 4, 5, 6);
        final Lottery lottery = this.createLottery(1, 2, 3, 14, 15, 16);
        // when
        final RewardType actual = winningLottery.resolveReward(lottery);
        // then
        assertThat(actual).isEqualByComparingTo(RewardType.THREE_NUMBERS_MATCHED);
    }

    @Test
    @DisplayName("4개 번호만 일치하는 경우 4등을 반환해야함")
    void resolveReward4() {
        // given
        final WinningLottery winningLottery = this.createWinningLottery(7, 1, 2, 3, 4, 5, 6);
        final Lottery lottery = this.createLottery(1, 2, 3, 4, 15, 16);
        // when
        final RewardType actual = winningLottery.resolveReward(lottery);
        // then
        assertThat(actual).isEqualByComparingTo(RewardType.FOUR_NUMBERS_MATCHED);
    }

    @Test
    @DisplayName("5개 번호만 일치하는 경우 3등을 반환해야함")
    void resolveReward5() {
        // given
        final WinningLottery winningLottery = this.createWinningLottery(7, 1, 2, 3, 4, 5, 6);
        final Lottery lottery = this.createLottery(1, 2, 3, 4, 5, 16);
        // when
        final RewardType actual = winningLottery.resolveReward(lottery);
        // then
        assertThat(actual).isEqualByComparingTo(RewardType.FIVE_NUMBERS_MATCHED);
    }

    @Test
    @DisplayName("5개 번호가 일치하고, 보너스 번호도 포함하는 경우 2등을 반환해야함")
    void resolveReward6() {
        // given
        final WinningLottery winningLottery = this.createWinningLottery(7, 1, 2, 3, 4, 5, 6);
        final Lottery lottery = this.createLottery(1, 2, 3, 4, 5, 7);
        // when
        final RewardType actual = winningLottery.resolveReward(lottery);
        // then
        assertThat(actual).isEqualByComparingTo(RewardType.FIVE_NUMBERS_AND_BONUS_MATCHED);
    }

    @Test
    @DisplayName("6개 번호가 일치하는 경우 1등을 반환해야함")
    void resolveReward7() {
        // given
        final WinningLottery winningLottery = this.createWinningLottery(7, 1, 2, 3, 4, 5, 6);
        final Lottery lottery = this.createLottery(1, 2, 3, 4, 5, 6);
        // when
        final RewardType actual = winningLottery.resolveReward(lottery);
        // then
        assertThat(actual).isEqualByComparingTo(RewardType.SIX_NUMBERS_MATCHED);
    }

    private Lottery createLottery(int... numbers) {
        final Set<LotteryNumber> lotteryNumberSet = Arrays.stream(numbers)
                .boxed()
                .map(LotteryNumber::from)
                .collect(Collectors.toSet());
        return Lottery.customizedInstance(lotteryNumberSet);
    }

    private WinningLottery createWinningLottery(int bonusNumber, int... numbers) {
        final Set<LotteryNumber> lotteryNumberSet = Arrays.stream(numbers)
                .boxed()
                .map(LotteryNumber::from)
                .collect(Collectors.toSet());
        final Lottery lottery = Lottery.customizedInstance(lotteryNumberSet);
        final LotteryNumber bonusLotteryNumber = LotteryNumber.from(bonusNumber);
        return WinningLottery.of(lottery, bonusLotteryNumber);
    }
}
