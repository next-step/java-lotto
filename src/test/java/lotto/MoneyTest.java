package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {
    private Money money;

    @BeforeEach
    void setUp() {
        money = new Money(10000);
    }

    @Test
    void 잔액_및_구매횟수_테스트() {
        assertThat(money.getBalance()).isEqualTo(10000);
        assertThat(money.purchaseCount()).isEqualTo(10);
        assertThat(money.purchased(3)).isEqualTo(7);
        assertThat(money.getBalance()).isEqualTo(7000);
    }

    @Test
    void validateMoneyCheck() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Money money = new Money(999);
            money.getBalance();
        }).withMessageMatching("금액이 부족합니다.");
    }
}
