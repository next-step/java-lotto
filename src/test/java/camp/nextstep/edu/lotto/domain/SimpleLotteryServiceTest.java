package camp.nextstep.edu.lotto.domain;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SimpleLotteryServiceTest implements LotteriesRewardHelper {

    private SimpleLotteryService simpleLotteryService;

    @BeforeEach
    void setup() {
        simpleLotteryService = new SimpleLotteryService();
    }

    @Test
    @DisplayName("0을 입력할 경우 0개의 로또를 반환합니다")
    void purchase_zero() {
        // given
        final int investment = 0;
        // when
        final Lotteries lottery = simpleLotteryService.purchase(investment);
        // then
        assertThat(lottery).hasSize(0);
    }

    @Test
    @DisplayName("양수를 입력할 경우 해당 숫자 / 1000 만큼의 로또를 반환합니다")
    void purchase() {
        // given
        final int investment = 14_000;
        // when
        final Lotteries lottery = simpleLotteryService.purchase(investment);
        // then
        assertThat(lottery).hasSize(14);
    }

    @Test
    @DisplayName("투자원금이 0원 이면 IllegalArgumentException 을 발생시킵니다")
    void calculateEarningsRate1() {
        final LotteriesReward lotteriesReward = this.create(RewardType.THREE_NUMBERS_MATCHED, 1);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> simpleLotteryService.calculateEarningsRate(0, lotteriesReward));
    }

    @Test
    @DisplayName("수익금이 0원 이면 0을 반환합니다")
    void calculateEarningsRate3() {
        // given
        final int investment = 5_000;
        LotteriesReward lotteriesReward = this.create();
        // when
        final double actual = simpleLotteryService.calculateEarningsRate(investment, lotteriesReward);
        // then
        assertThat(actual).isCloseTo(0, Percentage.withPercentage(1));
    }

    @Test
    @DisplayName("투자원금과 수익금을 입력하면 수익금 / 투자원금의 값을 반환합니다")
    void calculateEarningsRate4() {
        // given
        final int investment = 10_000;
        final LotteriesReward lotteriesReward = this.create(RewardType.FOUR_NUMBERS_MATCHED, 2);
        // when
        final double actual = simpleLotteryService.calculateEarningsRate(investment, lotteriesReward);
        // then
        assertThat(actual).isCloseTo(10, Percentage.withPercentage(1));
    }

    private LotteriesReward create() {
        final EnumMap<RewardType, Integer> rewardMap = new EnumMap<>(RewardType.class);
        return this.createLotteriesReward(rewardMap);
    }

    private LotteriesReward create(RewardType rewardType, int numberOfWinningLotteries) {
        final EnumMap<RewardType, Integer> rewardMap = new EnumMap<>(RewardType.class);
        rewardMap.put(rewardType, numberOfWinningLotteries);
        return createLotteriesReward(rewardMap);
    }
}