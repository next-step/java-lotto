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
    void testGetRank(int count, LottoRank expectedRank) {
        assertThat(LottoRank.getRank(count)).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> rankTestArguments() {
        return Stream.of(
            Arguments.of(6, LottoRank.FIRST),
            Arguments.of(5, LottoRank.SECOND),
            Arguments.of(4, LottoRank.THIRD),
            Arguments.of(3, LottoRank.FOURTH),
            Arguments.of(2, LottoRank.NONE),
            Arguments.of(1, LottoRank.NONE),
            Arguments.of(0, LottoRank.NONE)
            );
    }

}
