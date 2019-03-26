package lottery.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketCountTest {

    @Test
    public void test_생성() {
        TicketCount count = TicketCount.valueOf(14);

        assertThat(count.getAmount())
                .isEqualTo(14);
    }

    @Test
    public void test_덧셈() {
        TicketCount count = TicketCount.valueOf(14);

        assertThat(count.add(TicketCount.valueOf(6)))
                .isEqualTo(TicketCount.valueOf(20));
    }

    @Test
    public void test_뺄셈() {
        TicketCount count = TicketCount.valueOf(14);

        assertThat(count.subtract(TicketCount.valueOf(4)))
                .isEqualTo(TicketCount.valueOf(10));
    }

    @Test
    public void test_곱셈() {
        TicketCount count = TicketCount.valueOf(14);

        assertThat(count.times(TicketCount.valueOf(2)))
                .isEqualTo(TicketCount.valueOf(28));
    }

    @Test
    public void test_동일성() {
        Money money = Money.valueOf(14000);

        assertThat(money)
                .isEqualTo(Money.valueOf(14000))
                .hasSameHashCodeAs(Money.valueOf(14000));
    }
}