package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @DisplayName("잘못된 값 Money (String parameter) 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 999, -123, 000})
    public void constructorParamStringTest(int amount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(amount));
    }
}