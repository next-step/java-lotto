package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MoneyTest {
    @ParameterizedTest
    @ValueSource(strings = {"900", "200"})
    @DisplayName("입력한 금액이 1000원 미만이면 exception")
    void money_100원미만(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"14000=14", "3000=3"}, delimiter = '=')
    @DisplayName("생성 가능한 로또 갯수")
    public void lotteryCount(String input, int expectedCount) {
        //Given
        Money money = new Money(input);

        //When
        int usingLotteryCount = money.lotteryCount();

        //Then
        assertThat(usingLotteryCount).isEqualTo(expectedCount);
    }
}