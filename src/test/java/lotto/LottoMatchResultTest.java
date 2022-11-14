package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMatchResultTest {

    @DisplayName("3개 미만은 상금이 없습니다")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2 })
    void notRewarable(int notRewardableMatchCount) {
        LottoMatchResult lottoMatchResult = LottoMatchResult.of(notRewardableMatchCount, true);

        assertThat(lottoMatchResult.rewardable()).isFalse();
    }

    @DisplayName("3개 이상은 상금이 존재합니다")
    @ParameterizedTest
    @ValueSource(ints = { 3, 4, 5, 6 })
    void rewardable(int rewardableMatchCount) {
        LottoMatchResult lottoMatchResult = LottoMatchResult.of(rewardableMatchCount, false);

        assertThat(lottoMatchResult.rewardable()).isTrue();
    }
}
