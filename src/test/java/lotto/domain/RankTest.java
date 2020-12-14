package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("맞춘 갯수에 따라 Rank를 리턴한다. 만약 5개일 경우, 보너스볼에 따라 갈린다.")
    @ParameterizedTest
    @MethodSource("ProvideMatchCounts")
    void confirmRank(int countOfMatch, boolean matchBonus, Rank expectedRank) {
        Rank result = Rank.valueOf(countOfMatch, matchBonus);
        assertThat(result).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> ProvideMatchCounts() {
        return Stream.of(
                Arguments.of(6, true, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH)
        );
    }
}
