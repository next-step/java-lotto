package lotto;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {
    @DisplayName("1000원 미만의 값을 인자로 받으면 Money 객체 생성 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 999})
    void throwExceptionWhenMoneyIsLessThan1000(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(input);
        });
    }
}