package camp.nextstep.edu.lotto.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {
    @Test
    @DisplayName("음수 값으로 Money 를 만들 수 없습니다")
    void negative_value() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.from(-1));
    }

    @Test
    @DisplayName("0 으로 Money 를 만들 수 있습니다")
    void zero_value() {
        Money actual = Money.from(0);
        assertThat(actual).isInstanceOf(Money.class);
    }

    @Test
    @DisplayName("0으로 나누면 예외가 발생해야합니다")
    void divide_by_zero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.from(1).divideBy(Money.zero()));
    }

    @Test
    @DisplayName("0이 아닌 값으로 나누면, 1의 자리까지의 몫을 반환합니다")
    void divide() {
        Money money = Money.from(14_000);
        Money actual = money.divideBy(Money.from(1_000));
        assertThat(actual.intValue()).isEqualTo(14);
    }

    @Test
    @DisplayName("현재 money 의 값을 int 타입으로 반환합니다")
    void intValue() {
        Money money = Money.from(1_000);
        assertThat(money.intValue()).isEqualTo(1_000);
    }
}