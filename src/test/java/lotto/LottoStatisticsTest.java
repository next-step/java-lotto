package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistics;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

  @Test
  @DisplayName("로또 수익률 구하기")
  void givenLottoResult_ShouldGetRateOfReturn() {
    LottoStatistics lottoStatistics = new LottoStatistics(List.of(
        new LottoResult(3),
        new LottoResult(1),
        new LottoResult(2),
        new LottoResult(1),
        new LottoResult(0),
        new LottoResult(0)
    ));
    Money rateOfReturn = lottoStatistics.getRateOfReturn();
    assertThat(rateOfReturn.doubleValue()).isEqualTo(0.83);
  }
}