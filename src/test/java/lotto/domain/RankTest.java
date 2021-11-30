package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class RankTest {

    @ParameterizedTest(name = "일치하는 갯수의 랭크를 반환")
    @MethodSource("providedRanks")
    void create(int count, Rank rank) {
        assertThat(Rank.of(count, false)).isEqualTo(rank);
    }

    @Test
    @DisplayName("2등 생성 테스트")
    void second() {
        assertThat(Rank.of(Rank.SECOND.getMatch(), true)).isEqualTo(Rank.SECOND);
    }


    static Stream<Arguments> providedRanks() {
        return Stream.of(
            Arguments.of(0, Rank.NONE),
            Arguments.of(3, Rank.FIFTH),
            Arguments.of(4, Rank.FORTH),
            Arguments.of(5, Rank.THIRD),
            Arguments.of(6, Rank.FIRST)
        );
    }
}