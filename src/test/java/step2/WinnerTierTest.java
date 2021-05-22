package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import step2.model.LottoRank;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTierTest {

    @DisplayName("로또 번호로부터 랭크를 가져")
    @ParameterizedTest
    @MethodSource("provideEqualRank")
    void 랭크_일치_테스트(int same, LottoRank expected) {
        assertThat(expected).isEqualTo(LottoRank.valueOf(same));
    }

    private static Stream<Arguments> provideEqualRank() {
        return Stream.of(
            Arguments.of(1, LottoRank.MISS),
            Arguments.of(1, LottoRank.MISS),
            Arguments.of(2, LottoRank.MISS),
            Arguments.of(2, LottoRank.MISS),
            Arguments.of(3, LottoRank.MATCH_THREE),
            Arguments.of(3, LottoRank.MATCH_THREE),
            Arguments.of(4, LottoRank.MATCH_FOUR),
            Arguments.of(4, LottoRank.MATCH_FOUR),
            Arguments.of(5, LottoRank.MATCH_FIVE),
            Arguments.of(6, LottoRank.MATCH_SIX),
            Arguments.of(6, LottoRank.MATCH_SIX)
        );
    }
}