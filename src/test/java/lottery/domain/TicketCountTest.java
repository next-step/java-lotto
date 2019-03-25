package lottery.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketCountTest {

    @Test
    public void test_생성() {
        TicketCount count = new TicketCount(14);

        assertThat(count.amount)
                .isEqualTo(14);
    }

    @Test
    public void test_돈으로_생성() {
        TicketCount count = new TicketCount(new Money(14000));

        assertThat(count.amount)
                .isEqualTo(14);
    }

    @Test
    public void test_금액() {
        Money money = new Money(14000);
        TicketCount count = new TicketCount(money);

        assertThat(count.getPrice())
                .isEqualTo(money);
    }

    @Test
    public void test_덧셈() {
        TicketCount count = new TicketCount(14);

        assertThat(count.add(6))
                .isEqualTo(new TicketCount(20));
    }

    @Test
    public void test_뺄셈() {
        TicketCount count = new TicketCount(14);

        assertThat(count.subtract(4))
                .isEqualTo(new TicketCount(10));
    }

    @Test
    public void test_곱셈() {
        TicketCount count = new TicketCount(14);

        assertThat(count.multiply(2))
                .isEqualTo(new TicketCount(28));
    }

    @Test
    public void test_동일성() {
        Money money = new Money(14000);
        TicketCount count = new TicketCount(money);

        assertThat(count)
                .isEqualTo(new TicketCount(money));
        assertThat(count)
                .hasSameHashCodeAs(new TicketCount(money));
    }
}