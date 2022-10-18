package lotto.domain;

import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExchangerTest {

    @Test
    @DisplayName("구매 객체 비교 확인")
    void purchase() {
        // given
        String inputPrice = "14000";
        Exchanger exchanger = new Exchanger(inputPrice);

        // expected
        assertThat(exchanger).isEqualTo(new Exchanger(inputPrice));
    }

    @Test
    @DisplayName("구매 금액 확인")
    void purchase_amount() {
        // given
        String inputPrice = "14000";
        Exchanger exchanger = new Exchanger(inputPrice);

        // expected
        assertThat(exchanger.getPurchasePrice()).isEqualTo(14000);
    }

    @Test
    @DisplayName("로또 개수 확인")
    void lotto_amount() {
        // given
        String inputPrice = "14000";
        Exchanger exchanger = new Exchanger(inputPrice);

        // expected
        assertThat(exchanger.getAmount()).isEqualTo(14);
    }

    @Test
    @DisplayName("나눠지지 않는 수")
    void divide_exception() {
        // given
        String inputPrice = "14001";

        // expected
        assertThatThrownBy(() -> new Exchanger(inputPrice))
                .isInstanceOf(InvalidInputException.class);
    }

    @Test
    @DisplayName("잘못된 인풋")
    void input_exception() {
        // given
        String inputPrice = "-1,/";

        // expected
        assertThatThrownBy(() -> new Exchanger(inputPrice))
                .isInstanceOf(InvalidInputException.class);
    }

}
