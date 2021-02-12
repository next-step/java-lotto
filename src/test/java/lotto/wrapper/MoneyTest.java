package lotto.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @DisplayName("Count 인스턴스 생성 시 음수를 넣으면 예외 발생하는지.")
    @Test
    public void exceptWhenNegative() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Money에서 Count만큼 수동으로 로또 샀을 때, 자동 로또는 몇 개인지.")
    @Test
    void subManual() {
        Money money = new Money(2900);
        Count countManual = new Count(2);
        Money moneyRandom = new Money(900);
        assertThat(Money.subManual(money, countManual))
                .isEqualToComparingFieldByField(moneyRandom);
    }
}