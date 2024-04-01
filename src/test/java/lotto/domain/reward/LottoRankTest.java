package lotto.domain.reward;

import static lotto.domain.reward.LottoRank.FIFTH;
import static lotto.domain.reward.LottoRank.FIRST;
import static lotto.domain.reward.LottoRank.FOURTH;
import static lotto.domain.reward.LottoRank.NONE;
import static lotto.domain.reward.LottoRank.SECOND;
import static lotto.domain.reward.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("rankMatchingCounts")
    @DisplayName("당첨 번호 매칭 개수와 보너스 번호 일치 여부에 따라 순위를 반환한다.")
    void LottoRank_MatchingCountAndBonus(
            final int matchingCount,
            final boolean isMatchedBonus,
            final LottoRank expectedRank
    ) {
        assertThat(LottoRank.from(matchingCount, isMatchedBonus))
                .isEqualTo(expectedRank);
    }

    private static Stream<Arguments> rankMatchingCounts() {
        return Stream.of(
                Arguments.of(2, false, NONE),
                Arguments.of(2, true, NONE),
                Arguments.of(3, false, FIFTH),
                Arguments.of(3, true, FIFTH),
                Arguments.of(4, false, FOURTH),
                Arguments.of(4, true, FOURTH),
                Arguments.of(5, false, THIRD),
                Arguments.of(5, true, SECOND),
                Arguments.of(6, false, FIRST),
                Arguments.of(6, true, FIRST)
        );
    }

    @Test
    @DisplayName("당첨 번호 매칭 개수가 최대 기준보다 많거나, 최소 기준보다 적은 경우 예외를 던진다.")
    void LottoRank_MatchingCountLessThanMinimum_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.from(FIRST.matchingCount() + 1, false));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.from(NONE.matchingCount() - 1, false));
    }
}
