package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MoneyTest {
    @DisplayName("당첨금액을 생성한다.")
    @Test
    public void hitMoney() {
        Money money = new Money(5000);
        assertThat(money).isEqualTo(new Money(5000));
    }

    @DisplayName("구입금액이 로또 한장 금액보다 작을 경우 예외를 반환한다.")
    @Test
    public void purchase() {
        assertThatThrownBy(() -> {
            new Money(500);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
