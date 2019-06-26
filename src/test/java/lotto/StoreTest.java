package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StoreTest {

  @Test
  public void 사려는_수량을_입력하면_수량에맞는_로토를받는다() {
    Quantity autoQuantity = new Quantity(2);
    List<String> manual = new ArrayList<>();
    manual.add("1,2,3,4,5,6");
    manual.add("1,2,3,4,5,7");
    assertThat(Store.buyLottos(autoQuantity,manual))
        .extracting(Lottos::getQuantity)
        .isEqualTo(new Quantity(4));
  }

}
