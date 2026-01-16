package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThat(new LottoPurchase(money).count()).isEqualTo(5);
    }

    @Test
    @DisplayName("입력받은 금액보다 많은 갯수를 구매할 수 없다.")
    void manualList_size() {
        Money money = new Money(1000);
        List<String> list = List.of("1,2,3,4,5,6", "2,3,4,5,6,7", "3,4,5,6,7,8");

        LottoPurchase lottoPurchase = new LottoPurchase(money, list);
        assertThatThrownBy(() -> lottoPurchase.purchase())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
