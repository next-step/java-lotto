package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    static Stream<Arguments> find() {
        return Stream.of(
            Arguments.of(6, false, Rank.FIRST),
            Arguments.of(5, true, Rank.SECOND),
            Arguments.of(5, false, Rank.THIRD),
            Arguments.of(4, false, Rank.FOURTH),
            Arguments.of(3, false, Rank.FIFTH),
            Arguments.of(2, false, Rank.MISS),
            Arguments.of(1, false, Rank.MISS),
            Arguments.of(0, false, Rank.MISS)
        );
    }

    @ParameterizedTest
    @MethodSource("find")
    void find(int matches, boolean isMatchBonus, Rank expected) {
        assertThat(Rank.find(matches, isMatchBonus)).isEqualTo(expected);
    }
}