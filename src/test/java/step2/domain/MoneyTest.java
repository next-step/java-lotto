package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.exception.CustomException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1500, -2600})
    @DisplayName("음수의 돈을 입력하면 예외를 던진다")
    void moneyWithNegativeNumberThrowsException(int moneyAmount) {
        assertThrows(CustomException.class, () -> new Money(moneyAmount));
    }

}
