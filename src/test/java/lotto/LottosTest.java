package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("checkResults는 등수별 당첨 수를 리턴한다")
    @ParameterizedTest
    @MethodSource("checkResultsArguments")
    void checkResults_returnRankAndCountMap(LottoResults lottoResults, Rank rank, int expected) {
        assertThat(lottoResults.getCounts(rank)).isEqualTo(expected);
    }

    private static Stream<Arguments> checkResultsArguments() {
        Lotto lotto1 = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto4 = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 7, 8));
        Lotto lotto5 = new Lotto(() -> Arrays.asList(1, 2, 7, 8, 9, 10));
        Lotto lotto6 = new Lotto(() -> Arrays.asList(7, 8, 9, 10, 11, 12));

        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoResults lottoResults = lottos.checkResults(winningNumbers);

        return Stream.of(
                Arguments.of(lottoResults, Rank.FIRST, 1),
                Arguments.of(lottoResults, Rank.SECOND, 2),
                Arguments.of(lottoResults, Rank.THIRD, 1),
                Arguments.of(lottoResults, Rank.FOURTH, 0),
                Arguments.of(lottoResults, Rank.LOSING, 2)
        );
    }
}
