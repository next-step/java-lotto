package lotto.domain.sales;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBillTest {

    @Test
    void 로또_판매() {
        int money = 10000;
        int quantity = 10000 / 1000;

        LottoBill bill = new LottoBill(money);

        assertThat(bill.quantity()).isEqualTo(quantity);
    }

    @Test
    void 로또_판매_금액_0원() {
        assertThatThrownBy(() -> new LottoBill(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_PRICE.getMessage());
    }

    @Test
    void 로또_판매_금액_1000원단위_아님() {
        assertThatThrownBy(() -> new LottoBill(1222))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_PRICE.getMessage());
    }
}
