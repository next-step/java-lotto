package lotto.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("Money는 음수가 될 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -100})
    void createFailWhenNegativeValue(int value) {
        // when
        ThrowableAssert.ThrowingCallable callable = () -> Money.from(value);

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("금액은 음수일 수 없습니다.");
    }
}
