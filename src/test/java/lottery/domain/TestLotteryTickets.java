package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLotteryTickets {
    List<LotteryTicket> dummyTickets;

    @BeforeEach
    void setUp() {
        dummyTickets = new ArrayList<>(Arrays.asList(
                LotteryTicket.manual("1,2,3,4,5,6"),
                LotteryTicket.manual("7,8,9,10,11,12")
        ));
    }

    @Test
    void create() {
        LotteryTickets lotteryTickets = new LotteryTickets(dummyTickets);
        assertThat(lotteryTickets).isEqualTo(new LotteryTickets(dummyTickets));
    }
}
