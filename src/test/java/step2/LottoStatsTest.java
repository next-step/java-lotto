package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoStatsTest {

  @Test
  void decideFifthWinning() {
    LottoStats lottoStats = new LottoStats();
    lottoStats.decide(3, false);

    assertThat(lottoStats.rate(1000)).isEqualTo(5);
  }

  @Test
  void decideFourthWinning() {
    LottoStats lottoStats = new LottoStats();
    lottoStats.decide(4, false);

    assertThat(lottoStats.rate(1000)).isEqualTo(50);
  }

  @Test
  void decideThirdWinning() {
    LottoStats lottoStats = new LottoStats();
    lottoStats.decide(5, false);

    assertThat(lottoStats.rate(1000)).isEqualTo(1500);
  }

  @Test
  void decideSecondWinning() {
    LottoStats lottoStats = new LottoStats();
    lottoStats.decide(5, true);

    assertThat(lottoStats.rate(1000)).isEqualTo(30000);
  }

  @Test
  void decideFirstWinning() {
    LottoStats lottoStats = new LottoStats();
    lottoStats.decide(6, false);

    assertThat(lottoStats.rate(1000)).isEqualTo(2000000);
  }

  @Test
  void winningFourthWinningPayment14000() {
    LottoStats lottoStats = new LottoStats();
    lottoStats.decide(3, false);

    assertThat(lottoStats.rate(14000)).isEqualTo(0.35);
  }

  @Test
  void winningFourthWinningPayment1400() {
    LottoStats lottoStats = new LottoStats();
    lottoStats.decide(3, false);

    assertThat(lottoStats.rate(1400)).isEqualTo(5);
  }
}
