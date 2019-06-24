package camp.nextstep.edu.lotto;

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
        final RewardType actual = RewardType.from(3);
        assertThat(actual).isInstanceOf(RewardType.class);
    }

    @Test
    @DisplayName("score 가 0보다 작으면 IllegalArgumentException 을 발생시킵니다")
    void factoryMethod2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RewardType.from(-1))
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
        final RewardType rewardType = RewardType.from(score);
        final long actual = rewardType.getReward();
        assertThat(actual).isEqualTo(expected);
    }
}