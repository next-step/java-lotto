package lottery.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketCountTest {

    @Test
    public void test_생성() {
        TicketCount count = new TicketCount(new Money(14000));

        assertThat(count.count)
                .isEqualTo(14);
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