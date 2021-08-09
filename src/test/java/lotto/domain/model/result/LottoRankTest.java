package lotto.domain.model.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.domain.model.result.LottoRank;
import lotto.domain.model.result.MatchStats;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class LottoRankTest {

    @Test
    void of_throwsIllegalArgumentException() {
        MatchStats matchStats = MatchStats.of(7, true);
        assertThatThrownBy(() ->
                LottoRank.of(matchStats)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{index} factory method returns correct rank for count={0}, bonus={1}")
    @MethodSource
    void of_returnsCorrectLottoRank(int countOfMatch, boolean matchBonus, LottoRank expected) {
        MatchStats matchStats = MatchStats.of(countOfMatch, matchBonus);
        LottoRank lottoRank = LottoRank.of(matchStats);
        assertThat(lottoRank).isEqualTo(expected);
    }

    private static Stream<Arguments> of_returnsCorrectLottoRank() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(2, true, LottoRank.MISS),
                Arguments.of(2, false, LottoRank.MISS)
        );
    }
}
