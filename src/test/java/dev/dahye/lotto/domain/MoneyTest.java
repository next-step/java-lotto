package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Money 객체 테스트")
class MoneyTest {
    @ParameterizedTest(name = "money = {0}")
    @ValueSource(ints = {0, 1, 10002})
    @DisplayName("돈은 1000원 단위가 아닌 경우 IllegalArgument Exception throw")
    void validate_money(int money) {
        assertThrows(IllegalArgumentException.class, () -> new Money(money));
    }
}