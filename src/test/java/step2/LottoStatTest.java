package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoStatTest {

  @Test
  void firstStatEquals() {
    assertThat((LottoStat) new LottoFirstStat(1)).isEqualTo(new LottoFirstStat(1));
  }

  @Test
  void secondStatEquals() {
    assertThat((LottoStat) new LottoSecondStat(1)).isEqualTo(new LottoSecondStat(1));
  }

  @Test
  void thirdStatEquals() {
    assertThat((LottoStat) new LottoThirdStat(1)).isEqualTo(new LottoThirdStat(1));
  }

  @Test
  void fourthStatEquals() {
    assertThat((LottoStat) new LottoFourthStat(1)).isEqualTo(new LottoFourthStat(1));
  }
}
