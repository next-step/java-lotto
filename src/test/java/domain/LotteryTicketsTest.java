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
        List<Set<Integer>> manualNumber = Arrays.asList(new HashSet<>(Arrays.asList(11, 12, 13, 14, 15, 16)));

        LotteryTickets lotteryTickets = new LotteryTickets(new Store(1000).lotteryCount(), manualNumber);
        for(int i=0; i<lotteryTickets.size(); i++){
            assertThat(lotteryTickets.lotteryTicket(0).value(i)).isEqualTo(i+11);
        }
    }

}
