package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Store;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StoreTest {

  @Test
  @DisplayName("고객이 물건을 구입하는 테스트")
  void sellProduct() {
    Store store = new Store();
    assertThat(store.getProductsCount(10000)).isEqualTo(new Store(10));
  }
}
