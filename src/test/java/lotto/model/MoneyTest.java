package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MoneyTest {
    @Test
    @DisplayName("돈의 금액으로 equals 판단한다")
    public void equals() {
        Money money = new Money(1000);
        assertThat(money).isEqualTo(new Money(1000));
    }
}