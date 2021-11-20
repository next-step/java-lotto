package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTicketsTest {
    LotteryTickets lotteryTickets;

    @BeforeEach
    public void setup() {
        Store store = new Store(3000);
        lotteryTickets = new LotteryTickets(store.lotteryCount());
    }

    @Test
    @DisplayName("복권 여러개 확인")
    public void createIssueLotteryTicket() {
        assertThat(lotteryTickets.size()).isEqualTo(3);
    }

}
