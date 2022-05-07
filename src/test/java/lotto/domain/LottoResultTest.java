package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

  @Test
  @DisplayName("로또 수익률 구하기")
  void givenLottoResult_ShouldGetRateOfReturn() {
    LottoResult lottoResult = new LottoResult(List.of(
        LottoRank.of(3, false),
        LottoRank.of(1, false),
        LottoRank.of(2, false),
        LottoRank.of(1, false),
        LottoRank.of(0, false),
        LottoRank.of(0, false)
    ));
    double rateOfReturn = lottoResult.getRateOfReturn();
    assertThat(rateOfReturn).isEqualTo(0.83);
  }
}
