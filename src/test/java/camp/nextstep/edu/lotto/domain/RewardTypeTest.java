package camp.nextstep.edu.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Java6Assertions.assertThat;

class RewardTypeTest {

    @Test
    @DisplayName("인스턴스가 잘 생성되어야 합니다")
    void factoryMethod1() {
        final RewardType actual = RewardType.from(3, false);
        assertThat(actual).isInstanceOf(RewardType.class);
    }

    @Test
    @DisplayName("score 가 0보다 작으면 IllegalArgumentException 을 발생시킵니다")
    void factoryMethod2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RewardType.from(-1, false))
                .withMessageContaining("must be greater than");
    }

    @ParameterizedTest
    @CsvSource({
            "3,5000",
            "4,50000",
            "5,1500000",
            "6,2000000000"
    })
    @DisplayName("로또 숫자가 주어지면 당첨금액을 반환해야합니다")
    void getReward_3_5000(int score, long expected) {
        final RewardType rewardType = RewardType.from(score, false);
        final long actual = rewardType.getReward();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자가 5개 일치하고, 보너스 숫자가 일치하는 경우 2등으로 판단합니다")
    void from_5_true() {
        this.testRewardTypeFrom(5, true, RewardType.FIVE_NUMBERS_AND_BONUS_MATCHED);
    }

    @Test
    @DisplayName("숫자가 5개 일치하고, 보너스 숫자가 일치하지 않으면 기존처럼 5점으로 판단합니다")
    void from_5_false() {
        this.testRewardTypeFrom(5, false, RewardType.FIVE_NUMBERS_MATCHED);
    }

    @Test
    @DisplayName("숫자가 6개 일치하고, 보너스 숫자가 일치하지 않아도 기존처럼 6점으로 판단합니다")
    void from_6_true() {
        this.testRewardTypeFrom(6, true, RewardType.SIX_NUMBERS_MATCHED);
    }

    @Test
    @DisplayName("숫자가 6개 일치하면, 보너스 숫자가 일치해도 6점으로 판단합니다")
    void from_6_false() {
        this.testRewardTypeFrom(6, false, RewardType.SIX_NUMBERS_MATCHED);
    }

    @Test
    @DisplayName("숫자가 4개 일치하면, 보너스 숫자가 일치해도 4점으로 판단합니다")
    void from_4_true() {
        this.testRewardTypeFrom(4, true, RewardType.FOUR_NUMBERS_MATCHED);
    }

    @Test
    @DisplayName("숫자가 4개 일치하면, 보너스 숫자가 일치하지 않아도 4점으로 판단합니다")
    void from_4_false() {
        this.testRewardTypeFrom(4, false, RewardType.FOUR_NUMBERS_MATCHED);
    }

    @Test
    @DisplayName("숫자가 3개 일치하면, 보너스 숫자가 일치하지 않아도 3점으로 판단합니다")
    void from_3_true() {
        this.testRewardTypeFrom(3, true, RewardType.THREE_NUMBERS_MATCHED);
    }

    @Test
    @DisplayName("숫자가 3개 일치하면, 보너스 숫자가 일치하지 않아도 3점으로 판단합니다")
    void from_3_false() {
        this.testRewardTypeFrom(3, false, RewardType.THREE_NUMBERS_MATCHED);
    }

    @Test
    @DisplayName("숫자가 2개 일치하면, 보너스 숫자가 일치해도 보상이 없습니다")
    void from_2_true() {
        this.testRewardTypeFrom(2, true, RewardType.UNKNOWN);
    }

    @Test
    @DisplayName("숫자가 2개 일치하면, 보너스 숫자가 일치하지 않아도 보상이 없습니다")
    void from_2_false() {
        this.testRewardTypeFrom(2, true, RewardType.UNKNOWN);
    }

    @Test
    @DisplayName("숫자가 1개 일치하면, 보너스 숫자가 일치해도 보상이 없습니다")
    void from_1_true() {
        this.testRewardTypeFrom(1, true, RewardType.UNKNOWN);
    }

    @Test
    @DisplayName("숫자가 1개 일치하면, 보너스 숫자가 일치하지 않아도 보상이 없습니다")
    void from_1_false() {
        this.testRewardTypeFrom(1, true, RewardType.UNKNOWN);
    }

    @Test
    @DisplayName("아무 숫자도 일치하지 않고, 보너스 숫자도 일치하지 않으면 보상이 없습니다")
    void from_0_true() {
        this.testRewardTypeFrom(0, false, RewardType.UNKNOWN);
    }

    @Test
    @DisplayName("아무 숫자도 일치하지 않고, 보너스 숫자만 일치하면 보상이 없습니다")
    void from_0_false() {
        this.testRewardTypeFrom(0, true, RewardType.UNKNOWN);
    }

    private void testRewardTypeFrom(int score, boolean bonus, RewardType expected) {
        final RewardType rewardType = RewardType.from(score, bonus);
        assertThat(rewardType).isEqualTo(expected);
    }

}