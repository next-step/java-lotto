package lotto.domain;

import lotto.domian.LottoBundle;
import lotto.domian.Money;
import lotto.domian.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StoreTest {

    @DisplayName("금액 단위만큼 로또를 주문할 수 있다.")
    @Test
    public void order_MakeLottoDependsOnMoney_MakeLotto() {
        Money money = new Money(4000);
        int count = money.amount() / 1000;

        Store store = new Store();

        LottoBundle bundle = store.order(money);
        Assertions.assertThat(bundle.unfoldLottoBundle().size()).isEqualTo(count);
    }

    @DisplayName("음수만큼 구매하려고 할 경우 예외를 던진다.")
    @Test
    public void orderManual_NegativeNumber_ThrowException() {
        Store store = new Store();
        Assertions.assertThatThrownBy(() -> store.orderManual(new Money(1000), -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액보다 더 많이 구매하려고 하는 경우 예외를 던진다.")
    @Test
    public void orderManual_OrderMoreThanMoney_ThrowException() {
        Store store = new Store();
        Assertions.assertThatThrownBy(() -> store.orderManual(new Money(2000), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액만큼 수동로또를 산 후 나머지 금액을 반환한다.")
    @Test
    public void orderManual_ReturnChangeAfterManualLotto_ChangeMoneyCorrect() {
        Store store = new Store();
        Assertions.assertThat(store.orderManual(new Money(5000), 3)).isEqualTo(new Money(2000));
    }

    @DisplayName("수동으로 구매할 번호를 받아서 수동로또를 생성할 수 있다.")
    @Test
    public void makeManual_ReturnManualLottoList_Success() {
        Store store = new Store();
        List<String> manualLottoList = new ArrayList<>();
        manualLottoList.add("1, 2, 3, 4, 5, 6");
        manualLottoList.add("11, 22, 33, 44, 55, 66");
        manualLottoList.add("21, 22, 23, 24, 25, 26");

//        LottoBundle lottoBundle = store.makeManual(manualLottoList);

//        Assertions.assertThat(lottoBundle.unfoldLottoBundle().size()).isEqualTo(3);
    }

}
