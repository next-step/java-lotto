package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {


    static Stream<Arguments> matchRank() {
        return Stream.of(
            Arguments.of(3, true, Rank.THREE),
            Arguments.of(3, false, Rank.THREE),
            Arguments.of(4, true, Rank.FOUR),
            Arguments.of(4, false, Rank.FOUR),
            Arguments.of(5, true, Rank.FIVE_WITH_BONUS),
            Arguments.of(5, false, Rank.FIVE),
            Arguments.of(6, true, Rank.SIX)
        );
    }

    @ParameterizedTest
    @MethodSource("matchRank")
    @DisplayName("일치하는 로또 넘버 개수에 따른 Rank 가 매치")
    void 로또_넘버_개수_랭크_매치(int count, boolean isBonus, Rank rank) {
        Rank match = Rank.match(count, isBonus);
        assertThat(match).isEqualTo(rank);
    }

    @Test
    @DisplayName("getMatch 함수 일치하는지 확인")
    void getMatch() {
        Rank three = Rank.THREE;
        assertThat(three.getMatch()).isEqualTo(3);
    }
}
