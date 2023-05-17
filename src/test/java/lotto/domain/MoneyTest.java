package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyTest {

    @Test
    void 음수테스트() {
        assertThatThrownBy(()-> {
            Money money = new Money(-1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("금액은 0원 이상 이어야 합니다");
    }

    @Test
    void 더하기() {
        Money money = new Money(1000);
        Assertions.assertThat(money.add(new Money(500))).isEqualTo(new Money(1500));
    }

    @Test
    void 곱하기() {
        Money money = new Money(1000);
        Assertions.assertThat(money.multiply(3)).isEqualTo(new Money(3000));
    }

    @Test
    void 나누기() {
        Money money = new Money(3000);
        Assertions.assertThat(money.divide(new Money(1000))).isEqualTo(3);
    }

    @Test
    void 작다비교() {
        Money money = new Money(3000);
        Assertions.assertThat(money.isLessThan(new Money(3001))).isEqualTo(true);
    }

    @Test
    void 나머지비교() {
        Money money = new Money(3000);
        Assertions.assertThat(money.isMultipleOf(new Money(1000))).isEqualTo(true);
    }
}
