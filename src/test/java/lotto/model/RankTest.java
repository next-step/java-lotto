package lotto.model;

import lotto.model.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @MethodSource("rankProvider")
    @DisplayName("일치하는 갯수만큼 등수를 반환한다")
    void valueOfTest(int count, boolean matchBonus, Rank expectedRank) {
        assertThat(Rank.valueOf(count, matchBonus)).isEqualTo(expectedRank);
    }

    public static Stream<Arguments> rankProvider() {
        return Stream.of(
                Arguments.of(6, false,Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, true, Rank.FIFTH),
                Arguments.of(0, false, Rank.MISS)
        );
    }

}