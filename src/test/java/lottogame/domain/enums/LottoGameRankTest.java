package lottogame.domain.enums;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameRankTest {
    @ParameterizedTest(name = "티켓과 결과가 주어졌을 때 등수 탐색: {0} -> {1}")
    @MethodSource(value = "provideTicketAndResult")
    void findRank(int sameNumberCount, boolean hasSameBonusNumber, LottoGameRank expectedRank) {
        assertThat(LottoGameRank.findRank(sameNumberCount, hasSameBonusNumber)).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideTicketAndResult() {
        return Stream.of(
            Arguments.of(6, false, LottoGameRank.FIRST),
            Arguments.of(5, true, LottoGameRank.SECOND),
            Arguments.of(5, false, LottoGameRank.THIRD),
            Arguments.of(4, false, LottoGameRank.FOURTH),
            Arguments.of(3, false, LottoGameRank.FIFTH),
            Arguments.of(0, false, LottoGameRank.NONE)
        );
    }
}
