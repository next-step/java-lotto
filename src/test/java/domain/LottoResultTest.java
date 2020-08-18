package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @ParameterizedTest
    @MethodSource("generateData")
    void win(Rank rank, int hitNumber, boolean matchBonus, int expectCount, int expectMoney) {
        LottoResult lottoResult = LottoResult.of(rank);

        lottoResult.win(hitNumber, matchBonus);

        assertThat(lottoResult.getWinningCount()).isEqualTo(expectCount);
        assertThat(lottoResult.calculateWinningMoney()).isEqualTo(expectMoney);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Rank.FIRST, 6, false, 1, 2_000_000_000),
                Arguments.of(Rank.SECOND, 5, true, 1, 30_000_000),
                Arguments.of(Rank.THIRD, 5, false, 1, 1_500_000),
                Arguments.of(Rank.FOURTH, 4, false, 1, 50_000),
                Arguments.of(Rank.FIFTH, 3, false, 1, 5_000),
                Arguments.of(Rank.FIRST, 2, false, 0, 0)
        );
    }
}
