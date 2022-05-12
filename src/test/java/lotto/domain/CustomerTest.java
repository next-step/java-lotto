package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {
    @Test
    void 구매자_생성() {
        Customer customer = new Customer(14000);
        Assertions.assertThat(customer.equals(new Customer(14000))).isTrue();
    }
}