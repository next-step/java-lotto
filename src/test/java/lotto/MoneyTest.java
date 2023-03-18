package lotto;

import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("VO객체 선언에 대한 테스트")
    void moneyVoTest() {
        Assertions.assertThat(new Money(10)).isEqualTo(new Money(10));
    }
}
