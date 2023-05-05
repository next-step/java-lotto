package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.Money;
import lotto.domian.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StoreTest {

    @DisplayName("금액 단위만큼 로또를 주문할 수 있다.")
    @Test
    public void order_MakeLottoDependsOnMoney_MakeLotto() {
        Money money = new Money(4000);
        int count = money.amount() / 1000;

        List<Lotto> lottoList = Store.order(money);
        Assertions.assertThat(lottoList.size()).isEqualTo(count);
    }

}
