package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoStatTest {

  @Test
  void firstStat() {
    LottoStat lottoStat = new LottoFirstStat(1);

    assertThat(lottoStat.getMessage()).isEqualTo("6개 일치");
    assertThat(lottoStat.getAmount()).isEqualTo(2000000000);
    assertThat(lottoStat.getCount()).isEqualTo(1);
  }

  @Test
  void secondStat() {
    LottoStat lottoStat = new LottoSecondStat(1);

    assertThat(lottoStat.getMessage()).isEqualTo("5개 일치");
    assertThat(lottoStat.getAmount()).isEqualTo(1500000);
    assertThat(lottoStat.getCount()).isEqualTo(1);
  }

  @Test
  void thirdStat() {
    LottoStat lottoStat = new LottoThirdStat(1);

    assertThat(lottoStat.getMessage()).isEqualTo("4개 일치");
    assertThat(lottoStat.getAmount()).isEqualTo(50000);
    assertThat(lottoStat.getCount()).isEqualTo(1);
  }

  @Test
  void fourthStat() {
    LottoStat lottoStat = new LottoFirstStat(1);

    assertThat(lottoStat.getMessage()).isEqualTo("6개 일치");
    assertThat(lottoStat.getAmount()).isEqualTo(2000000000);
    assertThat(lottoStat.getCount()).isEqualTo(1);
  }
}
