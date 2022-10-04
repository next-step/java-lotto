package lotto.domain.enums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameRankTest {
    @ParameterizedTest(name = "티켓과 결과가 주어졌을 때 등수 탐색: {0} -> {1}")
    @MethodSource(value = "provideTicketAndResult")
    void findRank(int sameNumberCount, LottoGameRank expectedRank) {
        assertThat(LottoGameRank.findRank(sameNumberCount)).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideTicketAndResult() {
        return Stream.of(
            Arguments.of(6, LottoGameRank.FIRST),
            Arguments.of(5, LottoGameRank.THIRD),
            Arguments.of(4, LottoGameRank.FOURTH),
            Arguments.of(3, LottoGameRank.FIFTH),
            Arguments.of(0, LottoGameRank.NONE)
        );
    }
}
