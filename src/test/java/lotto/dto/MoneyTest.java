package lotto.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test(expected = IllegalArgumentException.class)
    public void 예외처리확인() {
        Money.inputUserMoney(500);
    }

    @Test
    public void 입금금액확인(){
        Money.inputUserMoney(1000);
        assertThat(Money.getMoney()).isEqualTo(1000);
    }
}

