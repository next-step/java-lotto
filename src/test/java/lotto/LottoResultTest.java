package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

  private LottoResult lottoResult;

  @BeforeEach
  void setUp() {
    lottoResult = new LottoResult();
  }

  @Test
  @DisplayName("상금 저장 및 확인")
  void testLottoResult() {
    this.lottoResult.recordHit(3);
    this.lottoResult.recordHit(0);
    this.lottoResult.recordHit(5);

    assertThat(lottoResult.calculateIncome())
        .isEqualTo(15_005_000);
  }

}