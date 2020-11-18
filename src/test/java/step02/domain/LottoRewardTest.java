package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoRewardTest {
    @DisplayName("생성자 테스트")
    @Test
    public void test_LottoReward_Contructor() {
        assertThat(LottoReward.of(3, 5000, 0)).isEqualTo(LottoReward.of(3, 5000, 0));
    }

    @DisplayName("LottoReward count 증가")
    @Test
    public void test_increaseCount() {
        LottoReward lottoReward = LottoReward.of(3, 5000, 0);
        assertThat(lottoReward.increaseCount())
                .isEqualTo(LottoReward.of(3, 5000, 1));
    }
}
