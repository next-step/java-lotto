package lotto.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserConsoleTest {

    @DisplayName("입력받은_금액이_천원이하_이거나_문자_이거나_음수인지_검증")
    @ParameterizedTest
    @ValueSource(strings = {"100", "-2", "abc"})
    void validateTypeLessThousandTest(String money) {
        assertThrows(IllegalArgumentException.class,
            () -> new Money(money));
    }
}