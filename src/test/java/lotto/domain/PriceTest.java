package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {

    @DisplayName(value = "정수 자료형으로 Price 객체를 생성할때, Price의 값은 정수 자료형과 동일하다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    void GivenMoneyWithIntType_WhenPriceGetValue_ThenEqualAsMoney(final int money) {
        final int PriceValue = Price.from(money).getValue();

        assertThat(PriceValue)
            .isEqualTo(money);
    }

    @DisplayName(value = "0으로 Price 객체를 생성할때, IllegalArgumentException이 발생한다.")
    @Test
    void GivenZero_WhenCreatePrice_ThenIllegalArgumentException() {
        assertThatThrownBy(() -> Price.from(0).getValue())
            .isInstanceOf(IllegalArgumentException.class);
        ;
    }

    @DisplayName(value = "1000으로 money가 나눠 떨어지지 않을 떄, IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {500, 1200, 2500, 3300})
    void GivenMoneyWithIntType_WhenNotDivisibleBy1000_ThenIllegalArgumentException(
        final int money) {
        assertThatThrownBy(() -> Price.from(money).getValue())
            .isInstanceOf(IllegalArgumentException.class);
    }
}