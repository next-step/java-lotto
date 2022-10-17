package lotto;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoReward;

public class LottoRewardTest {

    @DisplayName("당첨개수와 보너스볼 매치 여부에 맞는 상금을 조회합니다.")
    @Test
    void findByMatchResult_get_secondplace() {
        Optional<LottoReward> maybeLottoReward = LottoReward.findByMatchResult(5, true);

        Assertions.assertAll(
                () -> {
                    org.assertj.core.api.Assertions.assertThat(maybeLottoReward).isPresent();
                },
                () -> {
                    org.assertj.core.api.Assertions.assertThat(maybeLottoReward.get()).isEqualTo(LottoReward.SECOND_PLACE);
                },
                () -> {
                    org.assertj.core.api.Assertions.assertThat(maybeLottoReward.get().getRewardAmount()).isEqualTo(30000000);
                }
        );

    }

    @DisplayName("당첨개수와 보너스볼 매치 여부에 맞는 상금을 조회합니다.")
    @Test
    void findByMatchResult_get_thirdplace() {
        Optional<LottoReward> maybeLottoReward = LottoReward.findByMatchResult(5, false);

        Assertions.assertAll(
                () -> {
                    org.assertj.core.api.Assertions.assertThat(maybeLottoReward).isPresent();
                },
                () -> {
                    org.assertj.core.api.Assertions.assertThat(maybeLottoReward.get()).isEqualTo(LottoReward.THIRD_PLACE);
                },
                () -> {
                    org.assertj.core.api.Assertions.assertThat(maybeLottoReward.get().getRewardAmount()).isEqualTo(1500000);
                }
        );
    }

    @DisplayName("당첨개수와 보너스볼 매치 여부에 맞는 상금을 조회합니다.")
    @Test
    void findByMatchResult_get_noplace() {
        Optional<LottoReward> maybeLottoReward = LottoReward.findByMatchResult(1, false);

        org.assertj.core.api.Assertions.assertThat(maybeLottoReward).isEmpty();
    }
}
