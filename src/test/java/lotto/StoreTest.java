package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StoreTest {

  @Test
  public void 사려는_수량을_입력하면_수량에맞는_로토를받는다() {
    Quantity inputAndReult = new Quantity(14);
    assertThat(Store.buyLottos(inputAndReult))
        .extracting(Lottos::getQuantity)
        .isEqualTo(inputAndReult);
  }

}
