package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    static Stream<Arguments> provideParameters() {
        return Stream.of(
            Arguments.of(5, false, Rank.THIRD),
            Arguments.of(0, false, Rank.NONE),
            Arguments.of(3, false, Rank.FIFTH),
            Arguments.of(4, false, Rank.FOURTH),
            Arguments.of(5, true, Rank.SECOND),
            Arguments.of(6, false, Rank.FIRST)
        );
    }

    @DisplayName("일치 숫자 개수, 보너스 여부에 따른 등수 유효성 검사")
    @ParameterizedTest
    @MethodSource("provideParameters")
    void testGetRankValid(final int matches, final boolean hasBonus, final Rank rank) {
        assertThat(Rank.getRank(matches, hasBonus))
            .isEqualTo(rank);
    }
}
