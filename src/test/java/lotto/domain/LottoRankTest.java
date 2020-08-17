package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    private static Stream<Arguments> makeLottoRankData() {
        return Stream.of(
                Arguments.of(0, LottoRank.DROP),
                Arguments.of(1, LottoRank.DROP),
                Arguments.of(2, LottoRank.DROP),
                Arguments.of(3, LottoRank.FOURTH),
                Arguments.of(6, LottoRank.FIRST),
                Arguments.of(7, LottoRank.DROP)
        );
    }

    @DisplayName("")
    @ParameterizedTest
    @MethodSource("makeLottoRankData")
    void name(int matchCount, LottoRank lottoRank) {
        assertThat(LottoRank.of(matchCount)).isEqualTo(lottoRank);
    }
}
