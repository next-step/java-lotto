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
}
