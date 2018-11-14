package Domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static Domain.Money.LOTTO_PRICE;
import static Domain.Money.calculateAmount;

public class MoneyTest {

    @Test
    public void 구매금액으로_구매량을_구한다() {
        int moneyAmount = 14000;
        int amount = calculateAmount(moneyAmount);

        Assertions.assertThat(amount).isEqualTo(moneyAmount/LOTTO_PRICE);
    }

}