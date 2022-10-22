package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {
    @DisplayName("일치하는 갯수에 해당하는 상을 리턴한다.")
    @ParameterizedTest
    @MethodSource("prizeSet")
    void get(MatchingCount count, Prize expected) {
        assertThat(Prize.valueOf(count)).isEqualTo(expected);
    }

    @Test
    void exist() {
        assertThat(Prize.FIRST.exist()).isTrue();
        assertThat(Prize.NO_PRIZE.exist()).isFalse();
    }

    private static Stream<Arguments> prizeSet() {
        return Stream.of(
                Arguments.arguments(new MatchingCount(6, false), Prize.FIRST),
                Arguments.arguments(new MatchingCount(5, true), Prize.SECOND),
                Arguments.arguments(new MatchingCount(5, false), Prize.THIRD),
                Arguments.arguments(new MatchingCount(4, false), Prize.FOURTH),
                Arguments.arguments(new MatchingCount(4, true), Prize.FOURTH),
                Arguments.arguments(new MatchingCount(3, false), Prize.FIFTH),
                Arguments.arguments(new MatchingCount(3, true), Prize.FIFTH),
                Arguments.arguments(new MatchingCount(0, false), Prize.NO_PRIZE),
                Arguments.arguments(new MatchingCount(1, false), Prize.NO_PRIZE),
                Arguments.arguments(new MatchingCount(1, true), Prize.NO_PRIZE),
                Arguments.arguments(new MatchingCount(2, false), Prize.NO_PRIZE),
                Arguments.arguments(new MatchingCount(2, true), Prize.NO_PRIZE)
        );
    }
}
