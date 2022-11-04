package lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lottery.TestLotteryFactory.createLottery;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {

    List<Lottery> lotteries;

    @BeforeEach
    void setUp() {
        lotteries = List.of(
                createLottery(1, 2, 3, 4, 5, 6),
                createLottery(2, 3, 4, 5, 6, 7),
                createLottery(3, 4, 5, 6, 7, 8));
    }

    @Test
    void 로또_구매() {
        Customer customer = new Customer();
        customer.purchaseLotteries(10, lotteries);

        assertThat(customer.lotteries()).hasSize(10);
        assertThat(customer.lotteries()).containsAll(lotteries);
    }

    @Test
    void 로또_구매_invalid() {
        Customer customer = new Customer();

        assertThatThrownBy(() -> customer.purchaseLotteries(2, lotteries))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
