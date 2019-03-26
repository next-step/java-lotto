package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class LottoStoreTest {

  @Test
  public void test_insertMoney_1000() {

    // Given
    Money buyMoney = new Money(1000);

    // When
    int buyQuantity = LottoStore.quantity(buyMoney);

    // Then
    assertThat(buyQuantity).isEqualTo(1);
  }

  @Test
  public void test_insertMoney_1500() {

    // Given
    Money buyMoney = new Money(1500);

    // When
    int buyQuantity = LottoStore.quantity(buyMoney);

    // Then
    assertThat(buyQuantity).isEqualTo(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_insertMoney_500() {

    // Given
    Money insertMoney = new Money(500);

    // When
    LottoStore.quantity(insertMoney);
  }

  @Test
  public void test_insertMoney_14000() {

    // Given
    Money insertMoney = new Money(14000);

    // When
    int buyQuantity = LottoStore.quantity(insertMoney);

    // Then
    assertThat(buyQuantity).isEqualTo(14);
  }

  @Test
  public void test_buy_autoAndManual_test() {

    // Given
    int autoQuantity = 1;
    Lotto lotto = new Lotto(LottoTest.intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    List<Lotto> manualLottos = Collections.singletonList(lotto);

    // When
    Lottos lottos = LottoStore.buy(autoQuantity, manualLottos);

    // Then
    assertThat(lottos.getQuantity()).isEqualTo(2);
  }

  @Test
  public void test_buy_autoOnly_test() {

    // Given
    int autoQuantity = 5;

    // When
    Lottos lottos = LottoStore.buy(autoQuantity, new ArrayList<>());

    // Then
    assertThat(lottos.getQuantity()).isEqualTo(autoQuantity);
  }

  @Test
  public void test_buy_manualOnly_test() {

    // Given
    int autoQuantity = 0;
    Lotto lotto = new Lotto(LottoTest.intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    List<Lotto> manualLottos = Collections.singletonList(lotto);

    // When
    Lottos lottos = LottoStore.buy(autoQuantity, manualLottos);

    // Then
    assertThat(lottos.getQuantity()).isEqualTo(1);
  }
}
