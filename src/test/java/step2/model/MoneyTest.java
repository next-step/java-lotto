package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Money;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("valueOf()는 Money의 Instance를 반환한다")
    @ValueSource(ints = {1, 2, 3, 4})
    @ParameterizedTest
    void valueOf_Amount_MoneyInstance(int amount) {
        Money money = Money.valueOf(amount);
        assertThat(money).isInstanceOf(Money.class);
    }

    @DisplayName("useAmount()는 입력한 금액을 보유한 금액에서 차감한다")
    @MethodSource("provideMoneyForUseAmount")
    @ParameterizedTest
    void useAmount_UsedAmount_SubtractAmount(int totalAmount) {
        Money money = Money.valueOf(totalAmount);
        money.useAmount(LottoTicketPrice.PRICE_1000);
        assertThat(money).isEqualTo(Money.valueOf(totalAmount - LottoTicketPrice.PRICE_1000.getPrice()));
    }

    private static Stream<Arguments> provideMoneyForUseAmount() {
        return Stream.of(
                Arguments.of(10000),
                Arguments.of(8000),
                Arguments.of(5000),
                Arguments.of(1000)
        );
    }

    @DisplayName("useAmount()는 입력한 금액이 보유 금액보다 클 경우 예외가 발생한다")
    @Test
    void useAmount_NotAllowedAmount_ExceptionThrown() {
        Money money = Money.valueOf(0);

        assertThatThrownBy(() -> money.useAmount(LottoTicketPrice.PRICE_1000))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("보유중인 금액이 부족합니다.");
    }

    @DisplayName("isAvailableAmount()는 보유중인 금액과 비교해서 TRUE 또는 FALSE를 반환한다")
    @Test
    void isAvailableAmount_UsedAmount_Boolean() {
        Money money = Money.valueOf(1000);

        assertThat(money.isAvailableAmount(LottoTicketPrice.PRICE_1000)).isTrue();
        assertThat(money.isAvailableAmount(LottoTicketPrice.PRICE_2000)).isFalse();
    }
}
