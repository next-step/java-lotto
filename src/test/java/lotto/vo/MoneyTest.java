package lotto.vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {
    @Test
    public void 돈은_양수_이어야함() {
        // given
        long positive = 1;
        long zero = 0;
        long negative = -1;

        // when
        // then
        new Money(positive);
        new Money(zero);
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(negative));
    }

    @Test
    public void 금액_가져오기() {
        // given
        long amount = 1000;

        // when
        Money money = new Money(amount);

        // then
        assertThat(money.getAmount()).isEqualTo(amount);
    }

    @Test
    public void 금액이_더_큰지_비교() {
        // given
        Money thousand = new Money(1_000);
        Money hundred = new Money(100);

        // when
        boolean isLarger = thousand.isLargerThan(hundred);

        // then
        assertThat(isLarger).isTrue();
    }

    @Test
    public void 금액이_같은지_비교() {
        // given
        int amount = 1_000;
        Money money1 = new Money(amount);
        Money money2 = new Money(amount);

        // when
        boolean shouldBeTrue = money1.isEqualTo(money2);

        // then
        assertThat(shouldBeTrue).isTrue();
    }

    @Test
    public void 금액_곱하기_연산() {
        // given
        int amount = 1_000;
        Money money = new Money(amount);

        // when
        money = money.multiply(10);

        // then
        assertThat(money.getAmount()).isEqualTo(amount * 10);
    }
}
