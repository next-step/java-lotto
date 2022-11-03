package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoWinningStatsTest {
    @ParameterizedTest
    @MethodSource("lottoWinningStatsParams")
    public void constructor(List<Integer> winningNumbers, Lotto lotto) {
        LottoWinningStats lottoWinningStats = new LottoWinningStats(winningNumbers, lotto);
        assertThat(lottoWinningStats.getWinningNumbers()).containsAll(winningNumbers);
    }

    @ParameterizedTest
    @MethodSource("lottoWinningStatsParams")
    public void calculateWinningStats(List<Integer> winningNumbers, Lotto lotto) {
        LottoWinningStats lottoWinningStats = new LottoWinningStats(winningNumbers, lotto);
        lotto.generateNumbers();
        lottoWinningStats.calculateWinningStats();

        assertThat(lottoWinningStats.getWinningStats()).isNotEmpty();
        assertThat(lottoWinningStats.getWinningStats().size()).isEqualTo(lotto.getNumbersSize());
    }

    @ParameterizedTest
    @MethodSource("lottoWinningStatsParams")
    public void calculateWinningCounts(List<Integer> winningNumbers, Lotto lotto) {
        LottoWinningStats lottoWinningStats = new LottoWinningStats(winningNumbers, lotto);
        lotto.generateNumbers();

        lottoWinningStats.calculateWinningStats();
        lottoWinningStats.calculateWinningCounts();

        assertThat(lottoWinningStats.getWinningCounts().length).isEqualTo(LottoWinningStats.TOTAL_WINNING_COUNTS);
    }


    public static Stream<Arguments> lottoWinningStatsParams() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), new Lotto(15000)),
                Arguments.of(List.of(10, 25, 33, 34, 40, 45), new Lotto(10000)),
                Arguments.of(List.of(5, 6, 7, 8, 9, 1), new Lotto(1000)),
                Arguments.of(List.of(23, 38, 39, 41, 43, 45), new Lotto(50000)),
                Arguments.of(List.of(12, 17, 31, 32, 44, 45), new Lotto(200000))
        );
    }
}
