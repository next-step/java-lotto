package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoRewardTest {
    @DisplayName("생성자 테스트")
    @Test
    public void test_LottoReward_Contructor() {
        assertThat(LottoReward.of(3, 5000, 0))
                .isEqualTo(LottoReward.of(3, 5000, 0));
    }

    @DisplayName("LottoReward update")
    @Test
    public void test_updateCount() {
        LottoReward lottoReward = LottoReward.of(3, 5000, 0);
        assertThat(lottoReward.updateCount(3))
                .isEqualTo(LottoReward.of(3, 5000, 3));
    }
}
