package lotto.domain.reward;

import static lotto.config.LottoExceptionMessage.LOTTO_RANK_IS_NOT_FOUND;
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
    @DisplayName("당첨 번호 매칭 개수에 따라 순위를 반환한다.")
    void LottoRank_MatchingCount(final int matchingCount, final LottoRank expectedRank) {
        assertThat(LottoRank.from(matchingCount))
                .isEqualTo(expectedRank);
    }

    private static Stream<Arguments> rankMatchingCounts() {
        return Stream.of(
                Arguments.of(0, NONE),
                Arguments.of(1, NONE),
                Arguments.of(2, NONE),
                Arguments.of(3, FOURTH),
                Arguments.of(4, THIRD),
                Arguments.of(5, SECOND),
                Arguments.of(6, FIRST)
        );
    }

    @Test
    @DisplayName("당첨 번호 매칭 개수가 최소 기준보다 적은 경우 예외를 던진다.")
    void LottoRank_MatchingCountLessThanMinimum_Exception() {
        final int matchingCountLessThanMinimum = NONE.matchingCount() - 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.from(matchingCountLessThanMinimum))
                .withMessage(LOTTO_RANK_IS_NOT_FOUND.message(matchingCountLessThanMinimum));
    }

    @Test
    @DisplayName("당첨 번호 매칭 개수가 최대 기준보다 많은 경우 예외를 던진다.")
    void LottoRank_MatchingCountMoreThanMaximum_Exception() {
        final int matchingCountMoreThanMaximum = FIRST.matchingCount() + 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.from(matchingCountMoreThanMaximum))
                .withMessage(LOTTO_RANK_IS_NOT_FOUND.message(matchingCountMoreThanMaximum));
    }
}
