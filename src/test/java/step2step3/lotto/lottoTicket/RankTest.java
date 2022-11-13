package step2step3.lotto.lottoTicket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RankTest {

    @MethodSource
    @ParameterizedTest
    void 일치하는_개수를_통해_등급을_구할_수_있다(Rank rank, Rank result) {
        assertThat(rank).isEqualTo(result);
    }

    private static Stream<Arguments> 일치하는_개수를_통해_등급을_구할_수_있다() {
        return Stream.of(
                Arguments.of(Rank.rank(6, false), Rank.FIRST),
                Arguments.of(Rank.rank(5, true), Rank.SECOND),
                Arguments.of(Rank.rank(5, false), Rank.THIRD),
                Arguments.of(Rank.rank(4, false), Rank.FOURTH),
                Arguments.of(Rank.rank(3, false), Rank.FIFTH),
                Arguments.of(Rank.rank(0, false), Rank.NOTHING)
        );
    }

    @Test
    void 꽝이_아닐_경우_참을_반환한다() {
        assertTrue(Rank.FIRST.isNotNothing());
    }
}
