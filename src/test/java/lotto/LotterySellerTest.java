package lotto;

import lotto.domain.LotterySeller;
import lotto.domain.LotteryTicketList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotterySellerTest {

    @Test
    @DisplayName("buy를 통해서 로또티켓리스트가 가격에 맞게 생성되는지 테스트")
    void buy() {
        int amountOfMoneyToBuyTicket = 18000;
        int lotteryTicketPrice = 1000;
        int expectedNumberOfLotteryTickets = amountOfMoneyToBuyTicket / lotteryTicketPrice;

        LotterySeller lotterySeller = new LotterySeller();
        LotteryTicketList lotteryTicketList = lotterySeller.buy(amountOfMoneyToBuyTicket);

        assertThat(lotteryTicketList.getTicketList().size()).isEqualTo(expectedNumberOfLotteryTickets);
    }
}
