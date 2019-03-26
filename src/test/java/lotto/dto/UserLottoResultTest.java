package lotto.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottoResultTest {
    @Test
    public void 수익율테스트() {
        Money.inputUserMoney(14000);
        double price = 5000;
        assertThat(price).isEqualTo(5000.f);

        assertThat((int) (price / Money.getMoney() * 100)).isEqualTo(35);

        price = (int) (price / Money.getMoney() * 100);
        assertThat(price / 100.0).isEqualTo(0.35);
    }
}