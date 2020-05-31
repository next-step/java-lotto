package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.NotEnoughMoneyException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("valueOf() 정적 생성자는 Money 인스턴스를 반환한다")
    @ValueSource(ints = {0, 1000, 2000, 3000})
    @ParameterizedTest
    void valueOf_Amount_MoneyInstance(int amount) {
        Money money = Money.valueOf(amount);

        assertThat(money).isInstanceOf(Money.class);
        assertThat(money.getTotalAmount()).isEqualTo(amount);
    }

    @DisplayName("getBalance() 메소드는 현재 남은 금액을 반환한다")
    @ValueSource(ints = {0, 1000, 2000, 3000})
    @ParameterizedTest(name = "''{0}''를 입력하면 남은 금액은 ''{0}''이다")
    void getBalance_Amount_Remain(int amount) {
        Money money = Money.valueOf(amount);

        assertThat(money.getBalance()).isEqualTo(amount);
    }

    @DisplayName("useAmount() 메소드는 입력한 금액을 보유한 금액에서 차감한다")
    @MethodSource("provideMoneyForUseAmount")
    @ParameterizedTest(name = "''{0}''에서 1,000원 티켓 1장을 구입하면 ''{1}''이 남는다.")
    void useAmount_UsedAmount_SubtractAmount(Money purchaseMoney, Money expectedMoney) {
        purchaseMoney.useAmount(LottoTicketPrice.PRICE_1000);

        assertThat(purchaseMoney).isEqualTo(expectedMoney);
    }

    private static Stream<Arguments> provideMoneyForUseAmount() {
        return Stream.of(
                Arguments.of(Money.valueOf(10500), Money.valueOf(9500)),
                Arguments.of(Money.valueOf(10000), Money.valueOf(9000)),
                Arguments.of(Money.valueOf(5000), Money.valueOf(4000)),
                Arguments.of(Money.valueOf(1010), Money.valueOf(10))
        );
    }

    @DisplayName("useAmount() 메소는 입력한 금액이 보유 금액보다 클 경우 예외가 발생한다")
    @Test
    void useAmount_NotAllowedAmount_ExceptionThrown() {
        assertThatThrownBy(() -> Money.valueOf(999).useAmount(LottoTicketPrice.PRICE_1000))
                .isInstanceOf(NotEnoughMoneyException.class);
    }

    @DisplayName("isAvailableAmount() 메소드는 보유중인 금액과 비교해서 TRUE 또는 FALSE를 반환한다")
    @MethodSource("provideMoneyForIsAvailableAmount")
    @ParameterizedTest
    void isAvailableAmount_UsedAmount_Boolean(Money money, boolean expected) {
        assertThat(money.isAvailableAmount(LottoTicketPrice.PRICE_1000)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMoneyForIsAvailableAmount() {
        return Stream.of(
                Arguments.of(Money.valueOf(1001), true),
                Arguments.of(Money.valueOf(999), false)
        );
    }
}
