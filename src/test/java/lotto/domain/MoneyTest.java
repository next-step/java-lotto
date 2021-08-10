package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    @DisplayName("1000원 구매_성공 테스트")
    void 로또_1000원_구매_테스트() {
        Money money = new Money(1000);
        assertThat(money.getPurchaseMoney()).isEqualTo(1000);
        assertThat(money.getYield()).isEqualTo(0);
    }

    @Test
    @DisplayName("900원 구매 실패 테스트")
    void 로또_900원_구매_테스트() {
        assertThatThrownBy(() -> new Money(900))
                .isInstanceOf(RuntimeException.class);
    }
}
