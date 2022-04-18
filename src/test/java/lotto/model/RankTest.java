package lotto.model;

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
    void valueOfTest(int count, Rank expectedRank) {
        assertThat(Rank.valueOf(count)).isEqualTo(expectedRank);
    }

    public static Stream<Arguments> rankProvider() {
        return Stream.of(
                Arguments.of(6, Rank.FIRST),
                Arguments.of(5, Rank.SECOND),
                Arguments.of(4, Rank.THIRD),
                Arguments.of(3, Rank.FOURTH),
                Arguments.of(0, Rank.MISS)
        );
    }

}