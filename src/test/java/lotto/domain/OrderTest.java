package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    @Test
    void 오더가_잘_받아지는_지_확인한다() {
        Order order = new Order.Builder()
                .payment(4000)
                .selfNumber(Arrays.asList("2,3,4,5,1,6","4,5,6,7,2,1"))
                .build();

        assertThat(order.getPayment()).isEqualTo(4000);
        assertThat(order.getSelfNumbers().size()).isEqualTo(2);
    }
}
