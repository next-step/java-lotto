package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    private static Stream<Arguments> provideForRank() {
        return Stream.of(
                Arguments.of(new LottoMatchCount(0), false, Rank.EIGHTH),
                Arguments.of(new LottoMatchCount(1), false, Rank.SEVENTH),
                Arguments.of(new LottoMatchCount(2), false, Rank.SIXTH),
                Arguments.of(new LottoMatchCount(3), false, Rank.FIFTH),
                Arguments.of(new LottoMatchCount(4), false, Rank.FOURTH),
                Arguments.of(new LottoMatchCount(5), false, Rank.THIRD),
                Arguments.of(new LottoMatchCount(5), true, Rank.SECOND),
                Arguments.of(new LottoMatchCount(6), false, Rank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource("provideForRank")
    void rank(LottoMatchCount matchCount, boolean containBonusNumber, Rank rank) {
        assertThat(Rank.rankValue(matchCount, containBonusNumber)).isEqualTo(rank);
    }
}
