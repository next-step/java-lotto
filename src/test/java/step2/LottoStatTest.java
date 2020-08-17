package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoStatTest {

  @Test
  void firstStatEquals() {
    assertThat((LottoStat) new LottoStat(LottoRank.First, 1)).isEqualTo(new LottoStat(LottoRank.First, 1));
  }

  @Test
  void secondStatEquals() {
    assertThat((LottoStat) new LottoStat(LottoRank.Second, 1)).isEqualTo(new LottoStat(LottoRank.Second, 1));
  }

  @Test
  void thirdStatEquals() {
    assertThat((LottoStat) new LottoStat(LottoRank.Third, 1)).isEqualTo(new LottoStat(LottoRank.Third, 1));
  }

  @Test
  void fourthStatEquals() {
    assertThat((LottoStat) new LottoStat(LottoRank.Fourth, 1)).isEqualTo(new LottoStat(LottoRank.Fourth, 1));
  }
}
