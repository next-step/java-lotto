package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    void 금액_생성() {
        Money money = new Money(5000);

        assertThat(money.getValue()).isEqualTo(5000);
    }

    @Test
    void 음수면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 0보다 커야 합니다.");
    }

    @Test
    void 제로금액은_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 0보다 커야 합니다.");
    }

    @Test
    void 나눗셈의_비율을_계산한다() {
        Money money = new Money(10000);

        double rate = money.calculateRate(20000);

        assertThat(rate).isEqualTo(2.0);
    }

}
