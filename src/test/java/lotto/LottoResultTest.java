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
    this.sampleLottoResult.recordHit(3);
    this.sampleLottoResult.recordHit(0);
    this.sampleLottoResult.recordHit(5);

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
    assertThat(this.sampleLottoResult.getRecordedNumberOfHit(3))
        .isEqualTo(1);
  }
}
