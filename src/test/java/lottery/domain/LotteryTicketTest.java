package lottery.domain;

import org.junit.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketTest {

    @Test
    public void test_티켓_생성() {
        LotteryTicket.generate("1, 2, 3, 4, 5, 6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_티켓_생성_불가능_개수가_적음() {
        LotteryTicket.generate("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_티켓_생성_불가능_개수가_많음() {
        LotteryTicket.generate("1, 2, 3, 4, 5, 6, 7");
    }

    @Test
    public void test_매칭() {
        LotteryTicket ticket = LotteryTicket.generate("1, 2, 3, 4, 5, 6");
        assertThat(ticket.contains(LotteryNumber.of(1)))
                .isTrue();
    }

    @Test
    public void test_매칭되는_로또번호_갯수() {
        LotteryTicket ticket = LotteryTicket.generate("1, 2, 3, 4, 5, 6");

        assertThat(ticket.countMatchNumbers(LotteryTicket.generate("4, 5, 6, 7, 8, 9")))
                .isEqualTo(3);
    }

    @Test
    public void test_toString() {
        final LotteryTicket ticket = LotteryTicket.generate("1, 2, 3, 4, 5, 6");

        assertThat(ticket)
                .hasToString("[1, 2, 3, 4, 5, 6]");
    }
}