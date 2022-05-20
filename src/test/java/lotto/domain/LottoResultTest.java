package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

  @Test
  @DisplayName("구매한 전체 로또의 당첨 결과를 입력하면 당첨금 총액을 반환한다.")
  void totalPrizeAmount() {
    Money totalPrizeAmount = new LottoResult(List.of(Rank.TOP, Rank.THIRD)).totalPrizeAmount();
    assertThat(totalPrizeAmount).isEqualTo(Money.from(2000000000 + 1500000));
  }
}
