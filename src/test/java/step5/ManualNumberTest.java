package step5;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import step5.domain.ManualNumber;
import step5.domain.Money;
import step5.exception.NotEnoughInitManualMoneyException;

public class ManualNumberTest {


    @Test
    void 구입금액_수동금액_차감_성공() {
        Money money = new Money(10000);
        ManualNumber number = new ManualNumber(money,3);

        assertThat(money.getCurrentMoney()).isEqualTo(7000);
    }


    @Test
    void 구입금액_수동금액_차감_실패() {
        Money money = new Money(10000);
        assertThatThrownBy(() -> new ManualNumber(money,11))
                .isInstanceOf(NotEnoughInitManualMoneyException.class);
    }
}
