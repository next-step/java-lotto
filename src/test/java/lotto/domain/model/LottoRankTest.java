package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class LottoRankTest {

    @ParameterizedTest(name = "{index} LottoRank.of({0}, {1}) == {2}")
    @MethodSource
    void of_returnsCorrectLottoRank(int countOfMatch, boolean matchBonus, LottoRank expected) {
        LottoRank lottoRank = LottoRank.of(countOfMatch, matchBonus);
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

    @Test
    void of_throwsIllegalArgumentException() {
        assertThatThrownBy(() ->
                LottoRank.of(7, true)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
