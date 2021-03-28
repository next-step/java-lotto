package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.Amount;
import lotto.domain.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

  @Test
  @DisplayName("[Purchase] 수동 입력 번호 갯수 테스트")
  void manualNumberTest() {
    Amount amount = new Amount(14000, 1);
    Purchase purchase = new Purchase(amount, Arrays.asList("1, 2, 3, 4, 5, 6"));

    assertThat(purchase.manualNumbers().size()).isEqualTo(1);
  }
}
