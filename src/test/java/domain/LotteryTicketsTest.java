package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTicketsTest {
    LotteryTickets lotteryTickets;

    @BeforeEach
    public void setup() {
        Store store = new Store(3000);
        lotteryTickets = new LotteryTickets(store);
    }

    @Test
    @DisplayName("복권 여러개 발행")
    public void createIssueLotteryTicket() {
        assertThat(lotteryTickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("발행된 로또 번호가 6개인지 확인")
    public void checkLotteryNumber() {
        Assertions.assertAll(
                () -> assertThat(lotteryTickets.lotteryTicket(0).size()).isEqualTo(6),
                () -> assertThat(lotteryTickets.lotteryTicket(1).size()).isEqualTo(6),
                () -> assertThat(lotteryTickets.lotteryTicket(2).size()).isEqualTo(6)
        );
    }
}
