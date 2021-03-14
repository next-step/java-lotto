package lotto.domain;

import lotto.dto.LotteryPurchaseRequest;
import lotto.dto.LotteryTicketListDto;
import lotto.dto.WinningLotteryNumbersRequest;

public class LotteryGame {

    private LotteryTicketList lotteryTicketList;

    public void generateLotteryTickets(LotteryPurchaseRequest request) {
        lotteryTicketList = LotterySeller.purchase(request);
    }

    public LotteryTicketListDto getLotteryTickets() {
        return lotteryTicketList.getTicketList();
    }

    public void matchWinningLotteryNumbers(WinningLotteryNumbersRequest winningLotteryNumbersRequest) {
        WinningLotteryTicket lastWinningLotteryTicket = WinningLotteryTicket.ofRequest(winningLotteryNumbersRequest);
        lotteryTicketList.setLotteryPrize(lastWinningLotteryTicket);
    }
}
