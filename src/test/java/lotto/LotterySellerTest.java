package lotto;

import lotto.domain.LotterySeller;
import lotto.domain.LotteryTicketList;
import lotto.dto.LotteryPurchaseRequest;
import lotto.dto.LotteryTicketListDto;
import lotto.dto.LotteryNumberListDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotterySellerTest {

    @Test
    @DisplayName("buy를 통해서 로또티켓리스트가 가격에 맞게 생성되는지 테스트")
    void buy() {
        int amountOfMoneyToBuyTicket = 18000;
        int lotteryTicketPrice = 1000;
        int expectedNumberOfAutoLotteryTickets = amountOfMoneyToBuyTicket / lotteryTicketPrice;
        List<LotteryNumberListDto> listOfManualLotteryNumberList = Arrays.asList(new LotteryNumberListDto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LotteryNumberListDto(Arrays.asList(12, 14,15, 17, 18, 19)));

        LotteryPurchaseRequest lotteryPurchaseRequest = new LotteryPurchaseRequest(amountOfMoneyToBuyTicket, listOfManualLotteryNumberList);
        LotteryTicketList lotteryTicketList = LotterySeller.purchase(lotteryPurchaseRequest);
        LotteryTicketListDto ticketList = lotteryTicketList.getTicketList();

        assertThat(ticketList.totalSize())
                .isEqualTo(expectedNumberOfAutoLotteryTickets + listOfManualLotteryNumberList.size());
        assertThat(ticketList.autoSize())
                .isEqualTo(expectedNumberOfAutoLotteryTickets);
        assertThat(ticketList.manualSize())
                .isEqualTo(listOfManualLotteryNumberList.size());
    }
}
