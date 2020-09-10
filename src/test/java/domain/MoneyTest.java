package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("음수 값 테스트")
    @Test
    void 머니검증_테스트() {
        int input = 5000;
        assertThat(new Money(input));

        assertThatThrownBy(() -> {
            new Money(-1000);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERR");
    }

    @Test
    void 로또회수_테스트() {
        Money money = new Money(10000);
        assertThat(money.getLottoTries()).isEqualTo(10);
    }

    @Test
    void equalsTest() {
        Money money = new Money(1000);
        Money money2 = new Money(1000);

        assertThat(money.equals(money2)).isEqualTo(true);
    }
}
