package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningStatisticsTest {

  @ParameterizedTest
  @MethodSource("lottoAndWinningNumbersWithPrizeTierCntMapProvider")
  void newInstanceFromLottoAndWinningNumbers(Lotto lotto, WinningNumbers winningNumbers,
      Map<PrizeTier, Integer> prizeTierCntMap) {
    WinningStatistics winningStatistics = WinningStatistics
        .newInstanceFromLottoAndWinningNumbers(lotto, winningNumbers);

    for (PrizeTier prizeTier : prizeTierCntMap.keySet()) {
      assertThat(winningStatistics.getPrizeTierCntMap().get(prizeTier))
          .isEqualTo(prizeTierCntMap.get(prizeTier));
    }
  }

  static Stream<Arguments> lottoAndWinningNumbersWithPrizeTierCntMapProvider() {
    return Stream.of(
        arguments(new Lotto(Arrays.asList(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))),
            new WinningNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
            new HashMap<PrizeTier, Integer>() {{
              put(PrizeTier.MATCH_SIX, 1);
            }}
        )
    );
  }

  @ParameterizedTest
  @MethodSource("lottoAndWinningNumbersWithProfitProvider")
  void 수익률얼만지(Lotto lotto, WinningNumbers winningNumbers, double expected) {
    WinningStatistics winningStatistics = WinningStatistics
        .newInstanceFromLottoAndWinningNumbers(lotto, winningNumbers);

    assertThat(winningStatistics.getPrifitRate()).isEqualTo(expected);
  }

  static Stream<Arguments> lottoAndWinningNumbersWithProfitProvider() {
    return Stream.of(
        arguments(
            new Lotto(Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(11, 22, 33, 4, 5, 6))
            )),
            new WinningNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9))),
            0.35
        )
    );
  }
}