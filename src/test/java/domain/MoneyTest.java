package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static domain.Money.LOTTO_PRICE;
import static domain.Money.calculateAmount;

public class MoneyTest {

    @Test
    public void 구매금액으로_구매량을_구한다() {
        int parchaseMoney = 14000;
        LottoAmount amount = calculateAmount(Money.from(parchaseMoney));

        Assertions.assertThat(amount.getAmount()).isEqualTo(parchaseMoney/LOTTO_PRICE);
    }

}