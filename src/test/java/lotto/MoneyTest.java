package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {
    @DisplayName("Money 객체는 인자로 받는 금액(long type)에 따라 구별된다.")
    @ParameterizedTest
    @ValueSource(longs = {1000, 12000})
    void createMoneyTest(long input) {
        assertThat(new Money(input)).isEqualTo(new Money(input));
    }

    @DisplayName("음수를 입력받으면 객체는 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(longs = {-1, -10, -10000})
    void validateNegativeTest(long input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(input);
        });
    }

    @DisplayName("1000원 미만의 금액을 입력받으면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(longs = {0, 500, 999})
    void validateEnoughToBuyLottoTest(long input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(input);
        });
    }
}