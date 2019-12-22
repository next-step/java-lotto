package lotto.domain;

import lotto.common.exception.WrongOrderException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {

    @Test
    void 오더가_잘_받아지는__확인한다() {
        Order order = new Order.Builder()
                .payment(4000)
                .selfNumber(Arrays.asList("2,3,4,5,1,6", "4,5,6,7,2,1"))
                .build();

        assertThat(order.getPayment()).isEqualTo(4000);
        assertThat(order.getSelfNumbers().size()).isEqualTo(2);
    }

    @Test
    void 로또_가격보다_낮은_금액이_입력되면_WRONG_ORDER_EXCEPTION_발생() {
        assertThatThrownBy(() -> new Order.Builder()
                .payment(500)
                .build()).isInstanceOf(WrongOrderException.class);
    }

    @Test
    void 수동번호가_입력_금액_개수_이상을_초과하면_WRONG_ORDER_EXCEPTION_발생() {
        assertThatThrownBy(() -> new Order.Builder()
                .payment(1000)
                .selfNumber(Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6"))
                .build()).isInstanceOf(WrongOrderException.class);
    }
}
