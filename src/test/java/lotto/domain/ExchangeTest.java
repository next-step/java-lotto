package lotto.domain;

import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExchangeTest {

    @Test
    @DisplayName("구매 객체 비교 확인")
    void purchase() {
        // given
        String inputAmount = "14000";
        Exchange exchange = new Exchange(inputAmount);

        // expected
        assertThat(exchange).isEqualTo(new Exchange(inputAmount));
    }

    @Test
    @DisplayName("구매 금액 확인")
    void purchase_amount() {
        // given
        String inputAmount = "14000";
        Exchange exchange = new Exchange(inputAmount);

        // expected
        assertThat(exchange.getPurchaseAmount()).isEqualTo(14000);
    }

    @Test
    @DisplayName("로또 개수 확인")
    void lotto_amount() {
        // given
        String inputAmount = "14000";
        Exchange exchange = new Exchange(inputAmount);

        // expected
        assertThat(exchange.getLottoAmount()).isEqualTo(14);
    }

    @Test
    @DisplayName("나눠지지 않는 수")
    void divide_exception() {
        // given
        String inputAmount = "14001";

        // expected
        assertThatThrownBy(() -> new Exchange(inputAmount))
                .isInstanceOf(InvalidInputException.class);
    }

    @Test
    @DisplayName("잘못된 인풋")
    void input_exception() {
        // given
        String inputAmount = "-1,/";

        // expected
        assertThatThrownBy(() -> new Exchange(inputAmount))
                .isInstanceOf(InvalidInputException.class);
    }

}
