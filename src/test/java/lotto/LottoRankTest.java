package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.domain.LottoRank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoRankTest {

    @ParameterizedTest
    @MethodSource("rankTestArguments")
    void testGetRank(int count, boolean bonusMatch, LottoRank expectedRank) {
        assertThat(LottoRank.getRank(count, bonusMatch)).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> rankTestArguments() {
        return Stream.of(
            Arguments.of(6, false, LottoRank.FIRST),
            Arguments.of(5, true, LottoRank.SECOND),
            Arguments.of(5, false, LottoRank.THIRD),
            Arguments.of(4, true, LottoRank.FOURTH),
            Arguments.of(3, true, LottoRank.FIFTH),
            Arguments.of(2, true, LottoRank.NONE),
            Arguments.of(1, false, LottoRank.NONE),
            Arguments.of(0, false, LottoRank.NONE)
            );
    }

}
