package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTicketsTest {
    @Test
    @DisplayName("3000원 만큼 자동로또 생성")
    public void toIssueLotteryTicket() {
        LotteryTickets lotteryTickets = new LotteryTickets(new Store(3000).lotteryCount(), new ArrayList<>());
        assertThat(lotteryTickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("수동로또 생성")
    public void manualLottery() {
        Set<LotteryNumber> numbers = LotteryTicket.lotteryTicket(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LotteryTicket lotteryTicket = new LotteryTicket(numbers);

        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(numbers));
    }

}
