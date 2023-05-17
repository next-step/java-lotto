package lotto.domain;

import lotto.domian.*;
import lotto.ui.InputView;
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

        LottoBundle bundle = Store.order(money);
        Assertions.assertThat(bundle.unfoldLottoBundle().size()).isEqualTo(count);
    }

    @DisplayName("음수만큼 구매하려고 할 경우 예외를 던진다.")
    @Test
    public void orderManual_NegativeNumber_ThrowException() {
        Assertions.assertThatThrownBy(() -> Store.orderManual(new Money(1000), -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액보다 더 많이 구매하려고 하는 경우 예외를 던진다.")
    @Test
    public void orderManual_OrderMoreThanMoney_ThrowException() {
        Assertions.assertThatThrownBy(() -> Store.orderManual(new Money(2000), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액만큼 수동로또를 산 후 나머지 금액을 반환한다.")
    @Test
    public void orderManual_ReturnChangeAfterManualLotto_ChangeMoneyCorrect() {
        Assertions.assertThat(Store.orderManual(new Money(5000), 3)).isEqualTo(new Money(2000));
    }

    @DisplayName("구입금액에서 수동로또 갯수 차감한 수만큼 자동로또를 생성한다.")
    @Test
    public void order_Calculate_CountSame() {
        int purchaseMoney = 14000;
        int manualOrderCount = 3;
        int autoLottoSize = (14000 - 3 * Lotto.PURCHASE_UNIT) / Lotto.PURCHASE_UNIT;

        Money change = Store.orderManual(new Money(purchaseMoney), manualOrderCount);
        LottoBundle autoLottoBundle = Store.order(change);

        Assertions.assertThat(autoLottoBundle.unfoldLottoBundle().size()).isEqualTo(autoLottoSize);

    }

}
