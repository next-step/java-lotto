package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    static Stream<Arguments> rankSource() {
        return Stream.of(
                Arguments.arguments(
                        6, true, Rank.FIRST
                ),
                Arguments.arguments(
                        5, true, Rank.SECOND
                ),
                Arguments.arguments(
                        5, false, Rank.THIRD
                ),
                Arguments.arguments(
                        4, false, Rank.FOURTH
                ),
                Arguments.arguments(
                        2, true, Rank.NO_RANK
                )
        );
    }

    @ParameterizedTest
    @DisplayName("랭크 구하기 테스트")
    @MethodSource("rankSource")
    void rank(int matchCount, boolean matchBonus, Rank expected) {
        Rank actual = Rank.rank(matchCount, matchBonus);
        assertThat(actual).isEqualTo(expected);
    }

}