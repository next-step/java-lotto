package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {

    @DisplayName("금액은 0보다 큰 정수를 입력해야 함")
    @ValueSource(ints = {0, -100, -1000, -10000})
    @ParameterizedTest
    void positiveTest(int amount) {
        Assertions.assertThatIllegalArgumentException()
                  .isThrownBy(() -> new Money(amount));
    }

    @DisplayName("금액은 1,000원 단위로 입력해야 함")
    @ValueSource(ints = {500, 1500, 2200, 12345})
    @ParameterizedTest
    void moneyUnitTest(int amount) {
        Assertions.assertThatIllegalArgumentException()
                  .isThrownBy(() -> new Money(amount));
    }

    @DisplayName("로또 구매 가능 개수는 1000원 당 1장")
    @ValueSource(ints = {1000, 2000, 3000, 5000, 10000, 20000, 25000})
    @ParameterizedTest
    void buyLottosTest(int amount) {
        Money money = Money.of(amount);
        int expected = amount / 1000;
        assertEquals(expected, money.getBuyableLottoSize());
    }
}
