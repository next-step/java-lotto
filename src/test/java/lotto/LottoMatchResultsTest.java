package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoMatchResults;
import lotto.model.LottoReward;

public class LottoMatchResultsTest {

    @DisplayName("0개 일치하면 당첨금액은 0원이다")
    @Test
    void sumRewardAmount_notrewarded() {
        List<LottoMatchResult> lottoMatchResults = List.of(
                LottoMatchResult.of(0),
                LottoMatchResult.of(0),
                LottoMatchResult.of(0)
                );

        assertThat(new LottoMatchResults(lottoMatchResults).sumRewardAmount())
                .isEqualTo(0);
    }

    @Test
    void sumRewardAmount_rewarded() {
        List<LottoMatchResult> lottoMatchResults = List.of(
                LottoMatchResult.of(LottoReward.fourthPlace.getMatchCount())
        );

        assertThat(new LottoMatchResults(lottoMatchResults).sumRewardAmount()).isEqualTo(LottoReward.fourthPlace.getRewardAmount());
    }
}
