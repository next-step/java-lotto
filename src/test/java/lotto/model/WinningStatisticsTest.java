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
  void newInstanceFromLottoAndWinningNumbers(Lottos lottos, WinningLotto winningLotto,
      Map<PrizeTier, Integer> prizeTierCntMap) {
    WinningStatistics winningStatistics = WinningStatistics
        .newInstanceFromLottoAndWinningNumbers(lottos, winningLotto);

    for (PrizeTier prizeTier : prizeTierCntMap.keySet()) {
      assertThat(winningStatistics.getPrizeTierCntMap().get(prizeTier))
          .isEqualTo(prizeTierCntMap.get(prizeTier));
    }
  }

  static Stream<Arguments> lottoAndWinningNumbersWithPrizeTierCntMapProvider() {
    Lotto lotto_number1to6 = new Lotto(Arrays.asList(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)
    ));
    return Stream.of(
        arguments(new Lottos(Arrays.asList(lotto_number1to6)),
            new WinningLotto(lotto_number1to6, new LottoNumber(7)),
            new HashMap<PrizeTier, Integer>() {{
              put(PrizeTier.MATCH_SIX, 1);
            }}
        )
    );
  }

  @ParameterizedTest
  @MethodSource("lottoAndWinningNumbersWithProfitProvider")
  void 수익률얼만지(Lottos lottos, WinningLotto winningLotto, double expected) {
    WinningStatistics winningStatistics = WinningStatistics
        .newInstanceFromLottoAndWinningNumbers(lottos, winningLotto);

    assertThat(winningStatistics.getProfitRate()).isEqualTo(expected);
  }

  static Stream<Arguments> lottoAndWinningNumbersWithProfitProvider() {
    Lotto lotto_number1to6 = new Lotto(Arrays.asList(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)
    ));
    Lotto lotto_number11to16 = new Lotto(Arrays.asList(
        new LottoNumber(11),
        new LottoNumber(12),
        new LottoNumber(13),
        new LottoNumber(14),
        new LottoNumber(15),
        new LottoNumber(16)
    ));
    return Stream.of(
        arguments(
            new Lottos(Arrays.asList(
                lotto_number1to6,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16,
                lotto_number11to16)
            ),
            new WinningLotto(new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9))),
                new LottoNumber(10)
            ),
            0.35
        )
    );
  }
}