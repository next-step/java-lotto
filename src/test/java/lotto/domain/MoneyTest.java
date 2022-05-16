package lotto.domain;

import lotto.exception.InvalidMoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "100", "10000"})
    @DisplayName("입력한 숫자만큼의 값을 갖는 Money 객체 생성")
    void createMoneyTest(String input) {
        Money money = new Money(input);
        Assertions.assertThat(money.getTicketPrice()).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100", "-500"})
    @DisplayName("음수 입력 시 InvalidNumberException 발생")
    void throwInvalidNumberExceptionTest(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(InvalidMoneyException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.1", "!"})
    @DisplayName("숫자가 아닌 문자열 입력 시 NumberFormatException 발생")
    void throwNumberFormatExceptionTest(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("구매 금액을 제대로");
    }

    @ParameterizedTest
    @CsvSource(value = {"100:9900", "5000:5000", "10000:0"}, delimiter = ':')
    @DisplayName("티켓 가격을 뺀 만큼의 Money 반환")
    void subtractTest(String input, String expected) {
        Money money = new Money(10000);
        Money subtractedMoney = money.subtract(new Money(input));
        assertThat(subtractedMoney).isEqualTo(new Money(expected));
    }

    @Test
    @DisplayName("돈을 나눈 값을 반환한다")
    void divideTest() {
        //given
        Money cost = new Money(2000);
        Money principal = new Money(50000);

        //when
        double profitRatio = cost.divide(principal);

        //then
        assertThat(profitRatio).isEqualTo(0.04);
    }

}