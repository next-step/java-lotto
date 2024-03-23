package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @ParameterizedTest
    @MethodSource("countAndRank")
    void 당첨확인(int count, Rank rank) {
        assertThat(Rank.findRank(count)).isEqualTo(rank);
    }

    static Stream<Arguments> countAndRank() {
        return Stream.of(
                Arguments.arguments(6, Rank.FIRST),
                Arguments.arguments(5, Rank.SECOND),
                Arguments.arguments(4, Rank.THIRD),
                Arguments.arguments(3, Rank.FOURTH),
                Arguments.arguments(2, Rank.EMPTY),
                Arguments.arguments(1, Rank.EMPTY),
                Arguments.arguments(0, Rank.EMPTY)
        );
    }
}