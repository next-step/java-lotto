package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {

    @Test
    @DisplayName("Money 객체 생성")
    void new_money() {
        assertThat(new Money(14000L).getMoney()).isEqualTo(14000);
    }

    @Test
    @DisplayName("마이너스 금액은 생성할 수 없다.")
    void negative_money() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-14000L));
    }

    @Test
    @DisplayName("Money 객체 equalsAndHashCode test")
    void equals() {
        Money money1 = new Money(1000L);
        Money money2 = new Money(1000L);
        assertThat(money1).isEqualTo(money2);
    }
}
