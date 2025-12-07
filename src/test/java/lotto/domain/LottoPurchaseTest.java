package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("수동 생성한 리스트의 사이즈를 확인할 수 있다.")
    void manualList_size() {
        Money money = new Money(5000);
        List<String> list = List.of("1,2,3,4,5,6", "2,3,4,5,6,7", "3,4,5,6,7,8");

        LottoPurchase lottoPurchase = new LottoPurchase(money, list);

        assertThat(lottoPurchase.count()).isEqualTo(5);
        assertThat(lottoPurchase.count() - lottoPurchase.autoCount()).isEqualTo(3);
    }
}
