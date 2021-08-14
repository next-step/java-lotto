import Lotto.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {12, 34, 564})
    @DisplayName("천원단위가 아니면 예외를 발생시킨다.")
    public void isNot1000UnitException(int testMoney) {

        assertThatThrownBy(
                () -> Money.of(testMoney)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 15000, 30000})
    @DisplayName("천원단위가 1000원이면 검증은 통과된다..")
    public void is1000UnitPass(int testMoney) {

        Money money = new Money(testMoney);

        assertThat(money.getMoney()).isEqualTo(testMoney);

    }

    @Test
    @DisplayName("논리적 동치성은 두 머니가 같은값이면된다.")
        //왜이걸 검증해야되지?
    void twoMoneyIsSame() {
        assertThat(Money.of(1000)).isEqualTo(Money.of(1000));
    }

    @Test
    @DisplayName("금액만큼 횟수를 반환")
    void moneyIsreturnCount() {
        Money money = Money.of(50000);

        assertThat(money.getUnit()).isEqualTo(50);
    }
}
