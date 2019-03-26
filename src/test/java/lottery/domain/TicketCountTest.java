package lottery.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketCountTest {

    @Test
    public void test_생성() {
        TicketCount count = TicketCount.valueOf(14);

        assertThat(count.amount)
                .isEqualTo(14);
    }

    @Test
    public void test_돈으로_생성() {
        Money money = Money.valueOf(14000);
        TicketCount count = TicketCount.of(money);

        assertThat(count.amount)
                .isEqualTo(14);
    }

    @Test
    public void test_금액() {
        Money money = Money.valueOf(14000);
        TicketCount count = TicketCount.of(money);

        assertThat(count.getPrice())
                .isEqualTo(money);
    }

    @Test
    public void test_덧셈() {
        TicketCount count = TicketCount.valueOf(14);

        assertThat(count.add(6))
                .isEqualTo(TicketCount.valueOf(20));
    }

    @Test
    public void test_뺄셈() {
        TicketCount count = TicketCount.valueOf(14);

        assertThat(count.subtract(4))
                .isEqualTo(TicketCount.valueOf(10));
    }

    @Test
    public void test_곱셈() {
        TicketCount count = TicketCount.valueOf(14);

        assertThat(count.times(2))
                .isEqualTo(TicketCount.valueOf(28));
    }

    @Test
    public void test_동일성() {
        Money money = Money.valueOf(14000);
        TicketCount count = TicketCount.of(money);

        assertThat(count)
                .isEqualTo(TicketCount.of(money));
        assertThat(count)
                .hasSameHashCodeAs(TicketCount.of(money));
    }
}