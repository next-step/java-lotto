package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest
    @MethodSource("provideRanks")
    void matchRankTest(int matchNum, boolean Bonus, Rank result) {
        assertThat(Rank.rank(matchNum, Bonus)).isEqualTo(result);
    }

    private static Stream<Arguments> provideRanks() {
        return Stream.of(
                Arguments.of(0, false, Rank.MISS),
                Arguments.of(1, false, Rank.MISS),
                Arguments.of(2, false, Rank.MISS),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, false, Rank.FIRST)
                );
    }



    @Test
    void isMissTest() {
        //given
        Rank missRank = Rank.MISS;
        Rank noMissRank = Rank.FIFTH;

        //when
        assertThat(Rank.isWinning(missRank)).isFalse();
        assertThat(Rank.isWinning(noMissRank)).isTrue();
    }

}
