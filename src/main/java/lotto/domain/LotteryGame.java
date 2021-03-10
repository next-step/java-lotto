package lotto.domain;

import lotto.dto.LotteryGameRequest;
import lotto.dto.LotteryMatchResult;
import lotto.dto.LotteryStatisticMatchResult;
import lotto.dto.LotteryTicketDto;

import java.util.List;

public class LotteryGame {

    private final LotteryGameRule lotteryGameRule;

    private final LotteryTicketList lotteryTicketList;

    public LotteryGame() {
        lotteryGameRule = new LotteryGameRule();
        lotteryTicketList = new LotteryTicketList();

    }
    public void generateLotteryTickets(LotteryGameRequest userInput) {
        int numberOfLotteryTicketsToGenerate = userInput.getAmountOfMoney() / lotteryGameRule.getLotteryTicketPrice();
        lotteryTicketList.addAutoBulk(numberOfLotteryTicketsToGenerate, lotteryGameRule.getLotteryTicketPrice());
    }

    public List<LotteryTicketDto> getLotteryTickets() {
        return lotteryTicketList.getTicketList();
    }

    public LotteryStatisticMatchResult matchWinningLotteryNumbers(List<Integer> lastWinningLotteryNumbers) {
        LotteryTicket lastWinningLotteryTicket = new LotteryTicket(lastWinningLotteryNumbers);
        LotteryMatchResult matchResult = lotteryTicketList.match(lastWinningLotteryTicket);
        return new LotteryStatisticMatchResult(matchResult, lotteryGameRule);
    }
}
