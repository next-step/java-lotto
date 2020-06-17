package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("구입하는 금액을 생성한다")
    @Test
    void name() {
        Money money = Money.buy(14000);
        assertThat(money).isEqualTo(Money.buy(14000));
    }

    @DisplayName("0이나 음수값일 경우 에러를 발생한다")
    @Test
    void not_zero_or_negative() {
        assertThatThrownBy(() -> Money.buy(0))
                .isInstanceOf(IllegalArgumentException.class) ;

        assertThatThrownBy(() -> Money.buy(-1))
                .isInstanceOf(IllegalArgumentException.class) ;
    }

    @DisplayName("당첨 금액을 로또 구입 금액으로 나눈다")
    @Test
    void divide() {
        Money money = Money.buy(14000);
        int divide = money.divide(1000);
        assertThat(divide).isEqualTo(14);

    }
}
