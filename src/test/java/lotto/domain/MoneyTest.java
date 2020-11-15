package lotto.domain;

import lotto.exception.BadMoneyException;
import org.junit.jupiter.api.DisplayName;
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
                .isThrownBy(() -> new Money(money));
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
}
