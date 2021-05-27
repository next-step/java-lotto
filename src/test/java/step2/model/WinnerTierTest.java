package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinnerTierTest {

    @DisplayName("보너스 볼과 일치하는 로또 번호로부터 랭크를 가져")
    @ParameterizedTest
    @MethodSource("provideEqualRank")
    void 랭크_일치_테스트(int same, boolean matchBonus, LottoRank expected) {
        assertThat(expected).isEqualTo(LottoRank.valueOf(same, matchBonus));
    }

    private static Stream<Arguments> provideEqualRank() {
        return Stream.of(
            Arguments.of(1, true, LottoRank.MISS),
            Arguments.of(1, false, LottoRank.MISS),
            Arguments.of(2, true, LottoRank.MISS),
            Arguments.of(2, false, LottoRank.MISS),
            Arguments.of(3, true, LottoRank.MATCH_THREE),
            Arguments.of(3, false, LottoRank.MATCH_THREE),
            Arguments.of(4, true, LottoRank.MATCH_FOUR),
            Arguments.of(4, false, LottoRank.MATCH_FOUR),
            Arguments.of(5, true, LottoRank.MATCH_BONUS),
            Arguments.of(5, false, LottoRank.MATCH_FIVE),
            Arguments.of(6, true, LottoRank.MATCH_SIX),
            Arguments.of(6, false, LottoRank.MATCH_SIX)
        );
    }
}