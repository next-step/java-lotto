package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {

    @DisplayName("구매금액이 빈 값 또는 null인 경우 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_create_purchase(final String input) {

        assertThatThrownBy(() -> Purchase.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매금액은 입력해야 합니다.");
    }

    @DisplayName("로또 종이는 1000원 당 한장 구매 가능하다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "1001,1", "2000,2", "2100,2"})
    void create_purchase(final String purchase, final long count) {

        final Purchase amount = Purchase.from(purchase);

        assertThat(amount.available()).isEqualTo(count);
    }

    @DisplayName("로또 구매 금액과 상금의 대한 비율을 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,5000,5.00", "14000,5000,0.36", "20000,0,0.00"})
    void rate(final String purchase, final BigDecimal totalPrice, final String rate) {

        final Purchase amount = Purchase.from(purchase);
        amount.update(totalPrice);

        assertThat(amount.getRate()).isEqualTo(rate);
    }
}
