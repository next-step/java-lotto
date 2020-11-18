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

    @DisplayName("winningCounterCollections 의 내용을 반영하는 기능 테스트")
    @Test
    public void test_updateCounts() {
        List<WinningCounter> winningCounters = Arrays.asList(
                WinningCounter.of(0, 7),
                WinningCounter.of(1, 5),
                WinningCounter.of(2, 1),
                WinningCounter.of(3, 1)
        );

        WinningCounterCollections winningCounterCollections = WinningCounterCollections.of(winningCounters);
        LottoRewardCollections lottoRewardCollections = LottoRewardCollections.of(lottoRewards);

        assertThat(lottoRewardCollections.updateCounts(winningCounterCollections))
                .isEqualTo(
                        LottoRewardCollections.of(
                                Arrays.asList(
                                        LottoReward.of(3, 5000, 1),
                                        LottoReward.of(4, 50000, 0),
                                        LottoReward.of(5, 1500000, 0),
                                        LottoReward.of(6, 2000000000, 0)
                                )
                        )
                );
    }
}
