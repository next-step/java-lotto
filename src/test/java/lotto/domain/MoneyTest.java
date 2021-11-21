package lotto.domain;

import lotto.exception.MinimumAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @DisplayName("Money 생성 테스트")
    @ValueSource(ints = {1000, 2000, 3000})
    void createMoney(int purchaseAmount) {
        Money money = Money.from(purchaseAmount);

        assertThat(money).isInstanceOf(Money.class);
    }

    @ParameterizedTest
    @DisplayName("Money 생성 예외 테스트 1000원 이하 금액은 예외")
    @ValueSource(ints = {-1, 0, 999})
    void minumumAmountException(int purchaseAmount) {

        assertThatThrownBy(() -> Money.from(purchaseAmount)).isInstanceOf(MinimumAmountException.class);
    }

}