package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.WrongMoneyExcpetion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("돈금액은 0이상인 양수로 선언할수 있다.")
    void positive_money_amount(int amount) {
        assertThatCode(() -> new Money(amount))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    @DisplayName("돈금액 0미만의 음수로 선언될경우 예외를 던진다.")
    void negative_money_amount(int amount) {
        assertThatThrownBy(() -> new Money(amount))
            .isInstanceOf(WrongMoneyExcpetion.class);
    }

}