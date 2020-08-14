package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoAnalysisTest {

  @Test
  void analyzeFirstOne() {
    LottoAnalysis lottoAnalysis =
        new LottoAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));

    assertThat(lottoAnalysis.analyze()).isEqualTo(new LottoStats(1, 0, 0, 0));
  }

  @Test
  void analyzeSecondOne() {
    LottoAnalysis lottoAnalysis =
        new LottoAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arrays.asList(new Lotto(Arrays.asList(7, 2, 3, 4, 5, 6))));

    assertThat(lottoAnalysis.analyze()).isEqualTo(new LottoStats(0, 1, 0, 0));
  }

  @Test
  void analyzeThirdOne() {
    LottoAnalysis lottoAnalysis =
        new LottoAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arrays.asList(new Lotto(Arrays.asList(7, 8, 3, 4, 5, 6))));

    assertThat(lottoAnalysis.analyze()).isEqualTo(new LottoStats(0, 0, 1, 0));
  }

  @Test
  void analyzeOut() {
    LottoAnalysis lottoAnalysis =
        new LottoAnalysis(
            new Winning(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arrays.asList(new Lotto(Arrays.asList(7, 8, 9, 10, 5, 6))));

    assertThat(lottoAnalysis.analyze()).isEqualTo(new LottoStats(0, 0, 0, 0));
  }
}
