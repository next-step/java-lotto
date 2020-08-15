package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import step2.LottoStat.Grade;

class LottoStatTest {

  @Test
  void firstStat() {
    LottoStat lottoStat = new LottoFirstStat(1);

    assertThat(lottoStat.grade).isEqualTo(Grade.First);
    assertThat(lottoStat.getCount()).isEqualTo(1);
  }

  @Test
  void secondStat() {
    LottoStat lottoStat = new LottoSecondStat(1);

    assertThat(lottoStat.grade).isEqualTo(Grade.Second);
    assertThat(lottoStat.getCount()).isEqualTo(1);
  }

  @Test
  void thirdStat() {
    LottoStat lottoStat = new LottoThirdStat(1);

    assertThat(lottoStat.grade).isEqualTo(Grade.Third);
    assertThat(lottoStat.getCount()).isEqualTo(1);
  }

  @Test
  void fourthStat() {
    LottoStat lottoStat = new LottoFourthStat(1);

    assertThat(lottoStat.grade).isEqualTo(Grade.Fourth);
    assertThat(lottoStat.getCount()).isEqualTo(1);
  }
}
