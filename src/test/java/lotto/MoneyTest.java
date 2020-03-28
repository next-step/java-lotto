package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    @DisplayName("Money 생성 테스트")
    void moneyTest() {
        assertThat(
                new Money(100)
        ).isEqualTo(new Money(100));
    }

    @Test
    @DisplayName("price로 몇개 살수 있는지 테스트")
    void getPurchasableCountTest() {
        assertThat(
                new Money(1000).getPurchasableCount(1000)
        ).isEqualTo(1);
    }
}
