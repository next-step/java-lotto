package lotto;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.model.LottoReward;

public class LottoRewardTest {
    Optional<LottoReward> maybeLottoReward;

    @DisplayName("당첨됩니다")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "6,true,true,2000000000",
                    "6,false,true,2000000000",
                    "5,true,true,30000000",
            },
            delimiter = ','
    )
    void findByMatchResult_get_secondplace(int matchCount, boolean bonusNumberMatched, boolean isPresent, int rewardAmount) {
        Optional<LottoReward> maybeLottoReward = LottoReward.findByMatchResult(matchCount, bonusNumberMatched);

        Assertions.assertAll(
                () -> {
                    org.assertj.core.api.Assertions.assertThat(maybeLottoReward.isPresent()).isEqualTo(isPresent);
                },
                () -> {
                    org.assertj.core.api.Assertions.assertThat(maybeLottoReward.get().getRewardAmount()).isEqualTo(rewardAmount);
                }
        );
    }

    @DisplayName("당첨되지 않습니다")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1, true,true",
                    "1, false,true",
                    "2, true,true",
                    "2, false,true"
            },
            delimiter = ','
    )
    void findByMatchResult_get_noplace(int matchCount, boolean bonusNumberMatched, boolean isEmpty) {
        Optional<LottoReward> maybeLottoReward = LottoReward.findByMatchResult(matchCount, bonusNumberMatched);
        org.assertj.core.api.Assertions.assertThat(maybeLottoReward.isEmpty()).isEqualTo(isEmpty);
    }
}
