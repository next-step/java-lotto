package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SellerTest {

    @Test
    @DisplayName("구매 금액을 받아 1000원당 1장으로 로또를 판매한다.")
    void sellTest() {
        int money = 14000;

        var lottos = Seller.sell(money);

        Assertions.assertThat(lottos).hasSize(14);
    }
}
