package lotto.domain;

import lotto.exception.NegativePriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("구입 금액이 음수일 경우 NegativePriceException 을 발생한다.")
    @Test
    void negativeException() {
        final int price = -1;

        assertThatExceptionOfType(NegativePriceException.class).isThrownBy(
                () -> new Price(price)
        );
    }
}