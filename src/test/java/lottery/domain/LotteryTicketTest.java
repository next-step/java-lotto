package lottery.domain;

import org.junit.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketTest {

    @Test
    public void test_티켓_생성() {
        new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_티켓_생성_불가능_개수가_적음() {
        new LotteryTicket(Arrays.asList(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_티켓_생성_불가능_개수가_많음() {
        new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    public void test_toString() {
        final LotteryTicket ticket = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(ticket)
                .hasToString("[1, 2, 3, 4, 5, 6]");
    }
}