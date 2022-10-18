package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @Test
    void purchaseRandomLottery() {
        Customer customer = new Customer();
        customer.purchaseRandomLottery();

        assertThat(customer.getLotteries()).hasSize(1);
    }

}
