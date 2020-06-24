package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MoneyTest {
    @ParameterizedTest
    @ValueSource(strings = {"900", "200"})
    @DisplayName("입력한 금액이 1000원 미만이면 exception")
    void lotteryCount(String input) {
        Money money = new Money(input);
        assertThatThrownBy(() -> money.lotteryCount())
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

    @ParameterizedTest
    @CsvSource(value = {"10000,5000,15000", "2000,5000,7000"})
    @DisplayName("금액 합산하기")
    public void sum(int initialPrice, int addPrice, int sumPrice) {
        //Given
        Money money = new Money(initialPrice);

        //When
        Money actual = money.sum(new Money(addPrice));

        //Then
        assertThat(actual).isEqualTo(new Money(sumPrice));
    }
}