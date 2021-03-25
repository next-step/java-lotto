package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.exception.CustomException;
import step2.domain.exception.ErrorCode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1500, -2600})
    @DisplayName("음수의 돈을 입력하면 예외를 던진다")
    void moneyWithNegativeNumberThrowsException(int moneyAmount) {
        CustomException thrown = assertThrows(CustomException.class, () -> new Money(moneyAmount));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.NEGATIVE_MONEY_AMOUNT);
    }

}
