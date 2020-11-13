package lotto.domain;

import lotto.asset.ExceptionConst;
import lotto.exception.BadDividerException;
import lotto.exception.BadMoneyException;
import lotto.exception.NpeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @ParameterizedTest
    @DisplayName("money 가 0보다 작거나 같으면, BadMoneyException 이 발생한다.")
    @ValueSource(ints = {-379, -1, 0})
    public void constructor(int money) {
        assertThatExceptionOfType(BadMoneyException.class)
                .isThrownBy(() -> new Money(money))
                .withMessage(ExceptionConst.BAD_MONEY_MSG);
    }

    @ParameterizedTest
    @DisplayName("money 가 0보다 작거나 같으면, BadMoneyException 이 발생한다.")
    @ValueSource(strings = {"-379", "-1", "0"})
    public void constructor(String money) {
        assertThatExceptionOfType(BadMoneyException.class)
                .isThrownBy(() -> new Money(money))
                .withMessage(ExceptionConst.BAD_MONEY_MSG);
    }

    @Test
    @DisplayName("money 가 null 이면, NpeException 이 발생한다.")
    public void constructor() {
        assertThatExceptionOfType(NpeException.class)
                .isThrownBy(() -> new Money(null))
                .withMessage(ExceptionConst.NPE_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    public void testToString(String money) {
        assertThat(new Money(money).toString())
                .isEqualTo(money);
    }

    @ParameterizedTest
    @DisplayName("money 를 divider 로 나눈 값을 반환한다.")
    @CsvSource(value = {"9$2", "8$2", "2$8"}, delimiter = '$')
    public void divide(int money, int divider) {
        Money moneyObj = new Money(money);
        assertThat(moneyObj.divide(divider))
                .isEqualTo(money / divider);
    }

    @ParameterizedTest
    @DisplayName("money 를 divider 로 나눈 값을 반환한다.")
    @CsvSource(value = {"9$2", "8$2", "2$8"}, delimiter = '$')
    public void divide_money(int money, int divider) {
        Money moneyObj = new Money(money);
        Money dividerObj = new Money(divider);
        assertThat(moneyObj.divide(dividerObj))
                .isEqualTo(money / divider);
    }


    @ParameterizedTest
    @DisplayName("divider 가 0보다 작거나 같으면, BadDividerException 이 발생한다.")
    @ValueSource(ints = {-379, -1, 0})
    public void divide(int divider) {
        int money = 1000;
        Money moneyObj = new Money(money);
        assertThatExceptionOfType(BadDividerException.class)
                .isThrownBy(() -> moneyObj.divide(divider))
                .withMessage(ExceptionConst.BAD_DIVIDER_MSG);
    }
}
