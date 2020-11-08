package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningCheckerTest {
    private WinningChecker winningChecker;

    @BeforeEach
    void init() {
        winningChecker = new WinningChecker();
    }

    @ParameterizedTest
    @MethodSource("boughtLottos")
    @DisplayName("구매한 로또들과 지난 주 당첨 번호로, 등수별 당첨 여부와 수익이 얼마나 되는지 계산한다.")
    void winningAndStatisticTest(List<Lotto> boughtLottos, double expectedEarningRate, int expectedNumberOfMatchesSix) {
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningStatistic winningStatistic = winningChecker.getResult(winningNumbers, boughtLottos);

        assertAll(
                () -> assertThat(winningStatistic.getEarningsRate()).isEqualTo(expectedEarningRate),
                () -> assertThat(winningStatistic.getNumberOfWinningRank(WinningRank.MATCHES_SIX)).isEqualTo(expectedNumberOfMatchesSix)
        );
    }

    private static Stream<Arguments> boughtLottos() {
        return Stream.of(
                Arguments.of(lottosEarningZero(), 0, 0),
                Arguments.of(lottosEarningMax(), WinningRank.MATCHES_SIX.winningAmount / LottoFactory.PRICE_OF_ONE_LOTTO, 1)
        );
    }

    private static List<Lotto> lottosEarningZero() {
        List<Lotto> boughtLottos = new ArrayList<>();
        boughtLottos.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        return boughtLottos;
    }

    private static List<Lotto> lottosEarningMax() {
        List<Lotto> boughtLottos = new ArrayList<>();
        boughtLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        return boughtLottos;
    }
}
