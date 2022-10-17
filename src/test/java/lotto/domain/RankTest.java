package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    private static Stream<Arguments> provideForRank() {
        return Stream.of(
                Arguments.of(0, false, Rank.EIGHTH),
                Arguments.of(1, false, Rank.SEVENTH),
                Arguments.of(2, false, Rank.SIXTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, false, Rank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource("provideForRank")
    void rank(int matchCount, boolean containBonusNumber, Rank rank) {
        assertThat(Rank.rankValue(matchCount, containBonusNumber)).isEqualTo(rank);
    }
}
