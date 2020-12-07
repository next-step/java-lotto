package lotto.view;

import lotto.domain.Money;
import lotto.domain.exceptions.InvalidMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyInputViewTest {
    @DisplayName("사용자가 입력한 로또 구매 금액을 처리한다.")
    @Test
    void parseMoneyTest() {
        String userMoney = "12346";
        Money expected = new Money(12346L);

        MoneyInputView moneyInputview = new MoneyInputView(userMoney);

        assertThat(moneyInputview.parseMoney()).isEqualTo(expected);
    }

    @DisplayName("사용자가 숫자로 사용할 수 없는 값을 입력했을 때 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "", " 12", "aslcnlkal"})
    void invalidInputTest(String invalidValue) {
        assertThatThrownBy(() -> new MoneyInputView(invalidValue))
                .isInstanceOf(InvalidMoneyException.class);
    }
}
