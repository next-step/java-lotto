package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RankTest {

    @ParameterizedTest
    @MethodSource("rankTestData")
    @DisplayName("일치하는 번호 갯수에 따라 등수를 확인(보너스 제외)")
    void defaultRankTest(Rank expectedRank, boolean isMatchedBonus) {
        var rank = Rank.valueOf(expectedRank.getCountOfMatch(), isMatchedBonus);
        Assertions.assertThat(rank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> rankTestData() {
        return Stream.of(
                Arguments.of(Rank.FIRST, false),
                Arguments.of(Rank.SECOND, true),
                Arguments.of(Rank.THIRD, false),
                Arguments.of(Rank.FOURTH, false),
                Arguments.of(Rank.FIFTH, false)
        );
    }
}