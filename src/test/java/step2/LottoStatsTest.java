package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoStatsTest {

  @Test
  void rateZero() {
    LottoStats lottoStats = new LottoStats(
        Arrays.asList(
            new LottoFirstStat(0),
            new LottoSecondStat(0),
            new LottoThirdStat(0),
            new LottoFourthStat(0)));

    assertThat(lottoStats.rate(1000)).isEqualTo(0);
  }

  @Test
  void winningFourth() {
    LottoStats lottoStats = new LottoStats(
        Arrays.asList(
            new LottoFirstStat(0),
            new LottoSecondStat(0),
            new LottoThirdStat(0),
            new LottoFourthStat(1)));

    assertThat(lottoStats.rate(1000)).isEqualTo(5);
  }

  @Test
  void winningThird() {
    LottoStats lottoStats = new LottoStats(
        Arrays.asList(
            new LottoFirstStat(0),
            new LottoSecondStat(0),
            new LottoThirdStat(1),
            new LottoFourthStat(0)));

    assertThat(lottoStats.rate(1000)).isEqualTo(50);
  }

  @Test
  void winningSecond() {
    LottoStats lottoStats = new LottoStats(
        Arrays.asList(
            new LottoFirstStat(0),
            new LottoSecondStat(1),
            new LottoThirdStat(0),
            new LottoFourthStat(0)));

    assertThat(lottoStats.rate(1000)).isEqualTo(1500);
  }

  @Test
  void winningFirst() {
    LottoStats lottoStats = new LottoStats(
        Arrays.asList(
            new LottoFirstStat(1),
            new LottoSecondStat(0),
            new LottoThirdStat(0),
            new LottoFourthStat(0)));

    assertThat(lottoStats.rate(1000)).isEqualTo(2000000);
  }

  @Test
  void winningFourthPayment14000() {
    LottoStats lottoStats = new LottoStats(
        Arrays.asList(
            new LottoFirstStat(0),
            new LottoSecondStat(0),
            new LottoThirdStat(0),
            new LottoFourthStat(1)));

    assertThat(lottoStats.rate(14000)).isEqualTo(0.35);
  }

}
