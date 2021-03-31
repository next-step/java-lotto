package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RankTest {

    private static Stream<Arguments> valueOfRank() {
        return Stream.of(
                arguments(6, false, Rank.FIRST),
                arguments(5, true, Rank.SECOND),
                arguments(5, false, Rank.THIRD),
                arguments(4, false, Rank.FOURTH),
                arguments(3, false, Rank.FIFTH),
                arguments(1, false, Rank.OTHER)
        );
    }

    @ParameterizedTest
    @MethodSource("valueOfRank")
    public void valueOf(int matchCount, Boolean isBonusMatch, Rank expectRank) {
        // given

        // when
        Rank resultRank = expectRank.valueOf(matchCount, isBonusMatch);

        // then
        assertThat(resultRank).isEqualTo(expectRank);
    }
}
