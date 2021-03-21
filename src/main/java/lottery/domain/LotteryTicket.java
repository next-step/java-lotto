package lottery.domain;

import lottery.dto.LotteryNumbersDto;
import lottery.dto.RoundResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lottery.domain.LotteryTicketIssuer.LOTTERY_PRICE;

public class LotteryTicket {

    private final List<LotteryNumbers> lotteries;

    public LotteryTicket(List<LotteryNumbers> lotteries) {
        this.lotteries = lotteries;
    }

    public List<LotteryNumbersDto> exportLotteryNumbers() {
        List<LotteryNumbersDto> exportedNumbers = lotteries.stream()
                                                           .map(LotteryNumbers::export)
                                                           .collect(Collectors.toList());

        return Collections.unmodifiableList(exportedNumbers);
    }

    public RoundResult getResult(WinningLottery winningLottery) {
        List<Prize> prizes = lotteries.stream()
                                      .map(winningLottery::getPrize)
                                      .collect(Collectors.toList());

        double rateOfReturn = getRateOfReturn(prizes);

        return new RoundResult(prizes, rateOfReturn);
    }

    public double getRateOfReturn(List<Prize> prizes) {
        return prizes.stream()
                     .mapToDouble(prize -> prize.getWinnings() / (double) LOTTERY_PRICE)
                     .average()
                     .orElse(.0);
    }

}
