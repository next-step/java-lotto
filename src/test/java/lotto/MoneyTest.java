package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    @DisplayName("Money 생성 테스트")
    void moneyTest() {
        assertThat(
                new Money(100)
        ).isEqualTo(new Money(100));
    }
}
