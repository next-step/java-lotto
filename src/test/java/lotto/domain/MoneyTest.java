package lotto.domain;

import lotto.domain.lotto.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("돈은 1000원 단위여야 한다.")
    @Test
    public void money_MustBe1000Unit_IfNotThrowException() {
        int money = 1001;

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(money));
    }
}
