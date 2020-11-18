package step02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoRewardCollectionsTest {
    List<LottoReward> lottoRewards;

    @BeforeEach
    public void setup() {
        lottoRewards = Arrays.asList(
                LottoReward.of(3, 5000, 0),
                LottoReward.of(4, 50000, 0),
                LottoReward.of(5, 1500000, 0),
                LottoReward.of(6, 2000000000, 0)
        );
    }

    @DisplayName("생성자 테스트")
    @Test
    public void test_LottoRewardCollections_Constructor() {
        assertThat(LottoRewardCollections.of(lottoRewards))
                .isEqualTo(LottoRewardCollections.of(lottoRewards));
    }
}
