package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
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

    @ParameterizedTest
    @CsvSource({
            "1000, 5, 5000",
            "2000, 3, 6000",
            "3000, 0, 0"
    })
    @DisplayName("Money 객체는 배수 연산을 할 수 있다.")
    void calculate_Multiple(int input, int operand, int expectedResult) {
        Money money = Money.valueOf(input);
        money = money.multiple(operand);
        assertThat(money).isEqualTo(Money.valueOf(expectedResult));
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 2000, 3000",
            "4000, 5000, 9000",
            "1500, 2000, 3500"
    })
    @DisplayName("Money 객체는 덧셈 연산을 할 수 있다.")
    void calculate_Add(int input, int operand, int expectedResult) {
        Money money = Money.valueOf(input);
        Money otherMoney = Money.valueOf(operand);
        assertThat(money.add(otherMoney)).isEqualTo(Money.valueOf(expectedResult));
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 1000, 100",
            "3000, 2000, 150",
            "5000, 14000, 35"
    })
    @DisplayName("Money 객체는 퍼센트 연산을 할 수 있다.")
    void calculate_Percentage(int input, int operand, int expectedResult) {
        Money money = Money.valueOf(input);
        Money otherMoney = Money.valueOf(operand);
        assertThat(money.percentageBy(otherMoney)).isEqualTo(expectedResult);
    }
}
