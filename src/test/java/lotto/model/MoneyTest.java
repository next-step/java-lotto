package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    @DisplayName("Money.valueOf로 객체를 생성한다.")
    void create_Money() {
        Money money = Money.valueOf(Money.MINIMUM_VALUE);
        assertThat(money).isInstanceOf(Money.class);
    }

    @Test
    @DisplayName("Money에 허용된 범위를 벗어나면 예외가 발생한다.")
    void check_invalidLeftNumber_ExceptionThrown() {
        assertThatThrownBy(() -> Money.valueOf(Money.MINIMUM_VALUE - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Money.OUT_OF_RANGE_MESSAGE);
    }

    @Test
    @DisplayName("Money 객체는 동등성을 보장한다.")
    void equals_HasSameValue() {
        Money money1 = Money.valueOf(Money.MINIMUM_VALUE);
        Money money2 = Money.valueOf(Money.MINIMUM_VALUE);
        assertThat(money1).isEqualTo(money2);
    }

    @Test
    @DisplayName("Money 객체는 동일성을 보장한다.")
    void identify_HasSameValue() {
        Money money1 = Money.valueOf(Money.MINIMUM_VALUE);
        Money money2 = Money.valueOf(Money.MINIMUM_VALUE);
        assertThat(money1).isSameAs(money2);
    }

    @ParameterizedTest
    @CsvSource({
            "14000, 14",
            "14500, 14",
            "0, 0",
            "1000, 1",
            "4392, 4"
    })
    @DisplayName("Money 객체로 구매할 수 있는 로또 티켓의 수량을 계산한다.")
    void calculate_NumberOfTickets_ThatCanBePurchased(int input, int expectedResult) {
        Money money = Money.valueOf(input);
        assertThat(money.getNumberOfTicketForPurchase()).isEqualTo(expectedResult);
    }
}
