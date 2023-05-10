package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.constant.LottoRank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRanksTest {

    @ParameterizedTest
    @MethodSource("initGiveStatistics")
    void giveStatistics(LottoRanks lottoRanks, Map<LottoRank, Long> expected) {
        assertThat(lottoRanks.createStatistics()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("initRate")
    void rateTest(LottoRanks lottoRanks, Double expected) {
        assertThat(lottoRanks.createRate()).isEqualTo(expected);
    }

    static Stream<Arguments> initGiveStatistics() {
        return Stream.of(
            Arguments.of(new LottoRanks(List.of(LottoRank.FIRST)),
                Map.of(LottoRank.FIRST, 1L)),
            Arguments.of(new LottoRanks(List.of(LottoRank.FIRST, LottoRank.SECOND)),
                Map.of(LottoRank.FIRST, 1L, LottoRank.SECOND, 1L)),
            Arguments.of(new LottoRanks(List.of(LottoRank.FOURTH, LottoRank.MISS)),
                Map.of(LottoRank.FOURTH, 1L, LottoRank.MISS, 1L)),
            Arguments.of(new LottoRanks(List.of(LottoRank.MISS)),
                Map.of(LottoRank.MISS, 1L))
        );
    }

    static Stream<Arguments> initRate() {
        return Stream.of(
            Arguments.of(new LottoRanks(List.of(LottoRank.FIRST)), 2_000_000d),
            Arguments.of(new LottoRanks(List.of(LottoRank.FIRST, LottoRank.SECOND)), 1_000_750d),
            Arguments.of(new LottoRanks(List.of(LottoRank.FOURTH, LottoRank.MISS)), 2.5d),
            Arguments.of(new LottoRanks(List.of(LottoRank.MISS)), 0d)
        );
    }

}