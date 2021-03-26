package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoStaticResultTest {

  @Test
  @DisplayName("수익률 확인")
  public void calculate() {
    LottoStaticResult lottoStaticResult = new LottoStaticResult();
    lottoStaticResult.put(LottoRank.FOURTH);
    assertEquals(0.35, lottoStaticResult.calculate(14000));
  }
}
