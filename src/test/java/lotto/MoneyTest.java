package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 돈은 자신을 생성할 수 있다.
 * 돈은 다른 돈에서 자신의 돈을 뺄 수 있다.
 * 돈은 가중치와 다른 돈의 곱의 값에서 자신의 돈을 뺄 수 있다.
 */
public class MoneyTest {
    @Test
    @DisplayName("돈을 생성할 수 있다.")
    void constructorMethod() {
        assertThat(new Money(10000)).isEqualTo(new Money(10000));

        assertThatThrownBy(() -> {
            new Money(-10000);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다른 돈에서 자신의 돈을 뺄 수 있다.")
    void 돈_차감() {
        Money money = new Money(10000);
        assertThat(money.minus(new Money(4000))).isEqualTo(new Money(6000));
        assertThat(money.minus(5, new Money(1000))).isEqualTo(new Money(5000));
        assertThatThrownBy(() -> {
            money.minus(new Money(20000));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가중치와 다른 돈의 곱의 값에서 자신의 돈을 뺄 수 있다.")
    void 돈_차감_곱하기_가중치() {
        Money money = new Money(30000);
        money = money.minus(10, new Money(1000));
        assertThat(money).isEqualTo(new Money(20000));
    }
}
