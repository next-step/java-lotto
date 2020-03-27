package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PriceTest {

    @DisplayName("입력받은 값을 가격 객체로 생성할 수 있다.")
    @Test
    void create() {
        Price expect = new Price(1000);

        Price actual = new Price(1000);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("구입 금액이 1000원 이하일 경우 RuntimeException 을 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 990})
    void negativeException(int price) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                () -> new Price(price)
        );
    }
}