package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("당첨된 번호의 개수에 따라 등수를 반환한다")
    @ParameterizedTest
    @MethodSource("provideMatchCountAndContainBonusBall")
    void getRanks(int matchCount, boolean containBonusBall, Rank expected) {
        Rank rank = Rank.getRank(matchCount, containBonusBall);
        assertThat(rank).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMatchCountAndContainBonusBall() {
        return Stream.of(
            Arguments.of(6, false, Rank.FIRST),
            Arguments.of(5, true, Rank.SECOND),
            Arguments.of(5, false, Rank.THIRD),
            Arguments.of(4, false, Rank.FOURTH),
            Arguments.of(3, false, Rank.FIFTH),
            Arguments.of(2, false, Rank.MISS)
        );
    }

    @DisplayName("일치하는_당첨번호가_3미만일_경우_MISS반환")
    @ParameterizedTest
    @MethodSource("provideMatchCountLessThan3")
    void when_matchCount_is_less_than_3_then_return_MISS(int matchCount, boolean containBonusBall) {
        Rank rank = Rank.getRank(2, false);
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    private static Stream<Arguments> provideMatchCountLessThan3() {
        return Stream.of(
            Arguments.of(2, false),
            Arguments.of(1, false)
        );
    }
}
