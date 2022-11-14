package nextstep.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import nextstep.lotto.domain.LottoResult;
import nextstep.lotto.domain.LottoSummary;
import nextstep.lotto.domain.LottoWinCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSummaryTest {

  @DisplayName("수익률을 계산한다.")
  @Test
  public void spec01() {
    final LottoSummary lottoSummary1 = new LottoSummary(1000, List.of(LottoResult.FOURTH_PLACE));
    final LottoSummary lottoSummary2 = new LottoSummary(1000, List.of(
      LottoResult.FOURTH_PLACE, LottoResult.LOSE, LottoResult.LOSE, LottoResult.LOSE, LottoResult.LOSE)
    );
    Assertions.assertAll(
      () -> assertThat(lottoSummary1.rateOfReturn()).isEqualTo(new BigDecimal("5.00")),
      () -> assertThat(lottoSummary2.rateOfReturn()).isEqualTo(new BigDecimal("1.00"))
    );
  }

  @DisplayName("당첨된 정보를 조회한다.")
  @Test
  public void spec02() {
    final LottoSummary lottoSummary = new LottoSummary(1000, List.of(LottoResult.FIRST_PLACE, LottoResult.FOURTH_PLACE, LottoResult.FOURTH_PLACE, LottoResult.LOSE, LottoResult.LOSE));

    assertThat(lottoSummary.winResults()).containsExactly(
      new LottoWinCount(LottoResult.FOURTH_PLACE, 2),
      new LottoWinCount(LottoResult.FIRST_PLACE, 1)
    );
  }
}
