package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

  private LottoResult sampleLottoResult;

  @BeforeEach
  void setUp() {
    sampleLottoResult = new LottoResult();
    this.sampleLottoResult.recordHit(Rank.FIFTH);
    this.sampleLottoResult.recordHit(Rank.MISS);
    this.sampleLottoResult.recordHit(Rank.SECOND);

  }

  @Test
  @DisplayName("상금 저장 및 확인")
  void testLottoResult() {
    assertThat(sampleLottoResult.calculateIncome())
        .isEqualTo(30_050_000);
  }

  @Test
  @DisplayName("기록 확인")
  void testRecorded() {
    assertThat(this.sampleLottoResult.calculateIncome())
        .isEqualTo(Rank.FIFTH.getWinningReward() + Rank.SECOND.getWinningReward());
  }
}
