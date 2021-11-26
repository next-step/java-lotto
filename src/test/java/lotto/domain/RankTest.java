package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {

    static Stream<Arguments> generateRank() {
        return Stream.of(
            Arguments.of(0, false, Rank.NONE),
            Arguments.of(2, false, Rank.NONE),
            Arguments.of(3, false, Rank.FIFTH),
            Arguments.of(3, true, Rank.FIFTH),
            Arguments.of(5, false, Rank.THIRD),
            Arguments.of(5, true, Rank.SECOND)
        );
    }

    @ParameterizedTest
    @MethodSource("generateRank")
    @DisplayName("valueOf 테스트")
    void valueOf(long countOfMatch, boolean matchBonus, Rank rank) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(rank);
    }

}
