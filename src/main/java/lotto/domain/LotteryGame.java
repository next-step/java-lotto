package lotto.domain;

import lotto.dto.*;

import java.util.List;

public class LotteryGame {

    private LotteryTicketList lotteryTicketList;

    private final LotterySeller lotterySeller;

    public LotteryGame() {
        lotterySeller = new LotterySeller();
    }

    public void generateLotteryTickets(LotteryGenerateRequest request) {
        lotteryTicketList = lotterySeller.buy(request.getAmountOfMoney());
    }

    public List<LotteryTicketDto> getLotteryTickets() {
        return lotteryTicketList.getTicketList();
    }

    public LotteryStatisticMatchResult matchWinningLotteryNumbers(WinningLotteryNumbersRequest winningLotteryNumbersRequest) {
        WinningLotteryTicket lastWinningLotteryTicket = new WinningLotteryTicket(winningLotteryNumbersRequest.getLastWinningLotteryNumbers());
        LotteryMatchResult matchResult = lotteryTicketList.match(lastWinningLotteryTicket);
        return new LotteryStatisticMatchResult(matchResult, lotteryTicketList.getTotalPrice());
    }
}
