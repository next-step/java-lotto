package lotto.domain;

import lotto.dto.LotteryGenerateRequest;
import lotto.dto.LotteryStatisticMatchResult;
import lotto.dto.LotteryTicketDto;
import lotto.dto.WinningLotteryNumbersRequest;

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
        WinningLotteryTicket lastWinningLotteryTicket = WinningLotteryTicket.ofRequest(winningLotteryNumbersRequest);
        lotteryTicketList.setLotteryPrize(lastWinningLotteryTicket);
        return new LotteryStatisticMatchResult(lotteryTicketList);
    }
}
