package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoAnalysisTest {

  @Test
  void analyzeFirstOne() {
    LottoAnalysis lottoAnalysis =
        new LottoAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));

    assertThat(lottoAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().first(1).build()));
  }

  @Test
  void analyzeSecondOne() {
    LottoAnalysis lottoAnalysis =
        new LottoAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Arrays.asList(new Lotto(Arrays.asList(7, 2, 3, 4, 5, 6))));

    assertThat(lottoAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().second(1).build()));
  }

  @Test
  void analyzeThirdOne() {
    LottoAnalysis lottoAnalysis =
        new LottoAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Arrays.asList(new Lotto(Arrays.asList(8, 2, 3, 4, 5, 6))));

    assertThat(lottoAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().third(1).build()));
  }

  @Test
  void analyzeFourthOne() {
    LottoAnalysis lottoAnalysis =
        new LottoAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Arrays.asList(new Lotto(Arrays.asList(8, 9, 3, 4, 5, 6))));

    assertThat(lottoAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().fourth(1).build()));
  }

  @Test
  void analyzeFifthOne() {
    LottoAnalysis lottoAnalysis =
        new LottoAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Arrays.asList(new Lotto(Arrays.asList(8, 9, 10, 4, 5, 6))));

    assertThat(lottoAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().fifth(1).build()));
  }

  @Test
  void analyzeOut() {
    LottoAnalysis lottoAnalysis =
        new LottoAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Arrays.asList(new Lotto(Arrays.asList(7, 8, 9, 10, 5, 6))));

    assertThat(lottoAnalysis.analyze()).isEqualTo(new LottoStats(new WinningCounts.Builder().build()));
  }
}
