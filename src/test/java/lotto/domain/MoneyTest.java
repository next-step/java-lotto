package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    void 가진_금액에서_구매_가능_갯수_확인() {
        Money money = new Money(14000);
        Assertions.assertThat(money.calculateMaxQuantity()).isEqualTo(14);
    }

    @Test
    void 금액_차감_기능_개발() {

    }
}
