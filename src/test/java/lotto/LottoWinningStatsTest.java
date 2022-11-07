package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.enums.Ranks;
import lotto.numbers.Lotto;

public class LottoWinningStatsTest {
    @ParameterizedTest
    @MethodSource("lottoWinningStatsParams")
    public void calculateWinningStats(List<Integer> winningNumbers, Lotto lotto) {
        LottoWinningStats lottoWinningStats = new LottoWinningStats(lotto, winningNumbers);
    }

    @ParameterizedTest
    @MethodSource("lottoWinningStatsParams")
    public void getRanks(List<Integer> winningNumbers, Lotto lotto) {
        LottoWinningStats lottoWinningStats = new LottoWinningStats(lotto, winningNumbers);
        Map<Ranks, Integer> ranks = lottoWinningStats.getRanks();

        assertThat(ranks.isEmpty()).isInstanceOfAny(Boolean.class);
    }

    @ParameterizedTest
    @MethodSource("lottoWinningStatsParams")
    public void getYield(List<Integer> winningNumbers, Lotto lotto) {
        LottoWinningStats lottoWinningStats = new LottoWinningStats(lotto, winningNumbers);
        double yield = lottoWinningStats.getYield(lotto.getNumbersSize() * LottoWinningStats.PRICE);

        assertThat(yield).isNotNaN();
    }

    public static Stream<Arguments> lottoWinningStatsParams() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), new Lotto(1)),
                Arguments.of(List.of(10, 25, 33, 34, 40, 45), new Lotto(5)),
                Arguments.of(List.of(5, 6, 7, 8, 9, 1), new Lotto(10)),
                Arguments.of(List.of(23, 38, 39, 41, 43, 45), new Lotto(15)),
                Arguments.of(List.of(12, 17, 31, 32, 44, 45), new Lotto(30))
        );
    }
}
