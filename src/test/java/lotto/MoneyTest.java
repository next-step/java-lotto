package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 돈은 자신을 생성할 수 있다.
 * 돈은 다른 돈에서 자신의 돈을 뺄 수 있다.
 * 돈은 가중치와 다른 돈의 곱의 값에서 자신의 돈을 뺄 수 있다.
 */
public class MoneyTest {
    @Test
    @DisplayName("돈을 생성할 수 있다.")
    void 돈_생성() {
        Money money = new Money(10000);
        assertThat(money).isEqualTo(new Money(10000));
    }

    @Test
    @DisplayName("다른 돈에서 자신의 돈을 뺄 수 있다.")
    void 돈_차감() {
        Money money = new Money(10000);
        money = money.minus(4000);
        assertThat(money).isEqualTo(new Money(6000));
    }

    @Test
    @DisplayName("가중치와 다른 돈의 곱의 값에서 자신의 돈을 뺄 수 있다.")
    void 돈_차감_곱하기_가중치() {
        Money money = new Money(30000);
        money = money.minus(10, new Money(1000));
        assertThat(money).isEqualTo(new Money(20000));
    }
}
