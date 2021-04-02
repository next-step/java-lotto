package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MoneyTest {
    @DisplayName("당첨금액을 생성한다.")
    @Test
    public void hitMoney() {
        Money hitMoney = new Money(5000);
        assertThat(hitMoney).isEqualTo(new Money(5000));
    }
}
