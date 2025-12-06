package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {

    @Test
    @DisplayName("정해진 개수로 구매할 수 있다")
    void count() {
        LottoPurchase purchase = new LottoPurchase(new LottoCount(3));

        assertThat(purchase.count()).isEqualTo(3);
    }

    @Test
    @DisplayName("Money로부터 구매 가능한 로또 개수를 계산한다")
    void calculate() {
        Money money = new Money(5000);

        LottoPurchase purchase = new LottoPurchase(money);

        assertThat(purchase.count()).isEqualTo(5);
    }
}
