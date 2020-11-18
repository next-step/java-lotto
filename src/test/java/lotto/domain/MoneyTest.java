package lotto.domain;

import lotto.exception.BadDividerException;
import lotto.exception.BadMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @ParameterizedTest
    @DisplayName("money 가 0보다 작으면, BadMoneyException 이 발생한다.")
    @ValueSource(ints = {-379, -1})
    public void constructor(int money) {
        assertThatExceptionOfType(BadMoneyException.class)
                .isThrownBy(() -> new Money(money));
    }


    @ParameterizedTest
    @DisplayName("money 를 divider 로 나눈 값을 반환한다.")
    @CsvSource(value = {"9$2", "8$2", "2$8"}, delimiter = '$')
    public void divide(int money, int divider) {
        Money moneyObj = new Money(money);
        Money dividerObj = new Money(divider);
        assertThat(moneyObj.divide(dividerObj))
                .isEqualTo(money / divider);
    }

    @Test
    @DisplayName("0으로 나누면 BadDividerException 이 발생한다.")
    public void divide_by_zero() {
        assertThatExceptionOfType(BadDividerException.class)
                .isThrownBy(() -> new Money(1).divide(new Money(0)));
    }
}
