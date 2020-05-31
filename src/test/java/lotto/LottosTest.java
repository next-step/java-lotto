package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("checkResults는 등수별 당첨 수를 리턴한다")
    @ParameterizedTest
    @MethodSource("checkResultsArguments")
    void checkResults_returnRankAndCountMap(LottoResults lottoResults, Rank rank, int expected) {
        assertThat(lottoResults.getCounts(rank)).isEqualTo(expected);
    }

    private static Stream<Arguments> checkResultsArguments() {
        Lotto lotto1 = new Lotto(() -> Stream.of(1, 2, 3, 4, 5, 6).collect(toSet()));
        Lotto lotto2 = new Lotto(() -> Stream.of(1, 2, 3, 4, 5, 45).collect(toSet()));
        Lotto lotto3 = new Lotto(() -> Stream.of(1, 2, 3, 4, 5, 7).collect(toSet()));
        Lotto lotto4 = new Lotto(() -> Stream.of(1, 2, 3, 4, 7, 8).collect(toSet()));
        Lotto lotto4_2 = new Lotto(() -> Stream.of(1, 2, 3, 4, 7, 45).collect(toSet()));
        Lotto lotto5 = new Lotto(() -> Stream.of(1, 2, 3, 8, 9, 10).collect(toSet()));
        Lotto lotto5_2 = new Lotto(() -> Stream.of(1, 2, 3, 8, 9, 45).collect(toSet()));
        Lotto lotto6 = new Lotto(() -> Stream.of(7, 8, 9, 10, 11, 12).collect(toSet()));
        Lotto lotto6_2 = new Lotto(() -> Stream.of(7, 8, 9, 10, 11, 45).collect(toSet()));

        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto4_2, lotto5, lotto5_2, lotto6, lotto6_2));
        WinningNumbers winningNumbers = new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).collect(toSet()));
        LottoResults lottoResults = lottos.checkResults(winningNumbers, 45);

        return Stream.of(
                Arguments.of(lottoResults, Rank.FIRST, 1),
                Arguments.of(lottoResults, Rank.SECOND, 1),
                Arguments.of(lottoResults, Rank.THIRD, 1),
                Arguments.of(lottoResults, Rank.FOURTH, 2),
                Arguments.of(lottoResults, Rank.FIFTH, 2),
                Arguments.of(lottoResults, Rank.LOSING, 2)
        );
    }
}
