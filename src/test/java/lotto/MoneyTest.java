package lotto;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Money 클래스 테스트")
public class MoneyTest {

    @Test
    @DisplayName("같은 금액을 가진 Money 클래스는 equals 가 true 이다")
    void equalsTest() {
        assertThat(new Money(1000)).isEqualTo(Money.MONEY_BASE);
    }

    @Test
    @DisplayName("금액이 음수이면 예외가 발생한다.")
    void minusMoneyTest() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수");
    }

    @Test
    @DisplayName("금액이 천원 단위가 아니면 예외가 발생한다.")
    void notThousandMoneyTest() {
        assertThatThrownBy(() -> new Money(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("천원");
    }

    @Test
    @DisplayName("Money가 단위(천원) 기준 몇개 있는지 getUnitCount() 로 알 수 있다. ")
    void getUnitCountTest() {
        Money money = new Money(14000);

        assertThat(money.getUnitCount()).isEqualTo(14);
    }
}
