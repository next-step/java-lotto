package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottosAnalysisTest {

  @Test
  void analyzeFirstOne() {
    LottosAnalysis lottosAnalysis =
        new LottosAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Lottos.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));

    assertThat(lottosAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().first(1).build()));
  }

  @Test
  void analyzeSecondOne() {
    LottosAnalysis lottosAnalysis =
        new LottosAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Lottos.of(new Lotto(Arrays.asList(7, 2, 3, 4, 5, 6))));

    assertThat(lottosAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().second(1).build()));
  }

  @Test
  void analyzeThirdOne() {
    LottosAnalysis lottosAnalysis =
        new LottosAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Lottos.of(new Lotto(Arrays.asList(8, 2, 3, 4, 5, 6))));

    assertThat(lottosAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().third(1).build()));
  }

  @Test
  void analyzeFourthOne() {
    LottosAnalysis lottosAnalysis =
        new LottosAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Lottos.of(new Lotto(Arrays.asList(8, 9, 3, 4, 5, 6))));

    assertThat(lottosAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().fourth(1).build()));
  }

  @Test
  void analyzeFifthOne() {
    LottosAnalysis lottosAnalysis =
        new LottosAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Lottos.of(new Lotto(Arrays.asList(8, 9, 10, 4, 5, 6))));

    assertThat(lottosAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().fifth(1).build()));
  }

  @Test
  void analyzeOut() {
    LottosAnalysis lottosAnalysis =
        new LottosAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Lottos.of(new Lotto(Arrays.asList(7, 8, 9, 10, 5, 6))));

    assertThat(lottosAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().build()));
  }
}
