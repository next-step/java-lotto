package lottery.domain;

import lottery.dto.LotteryProxy;
import lottery.dto.ReadonlyLottery;
import lottery.dto.ReadonlyLotteryTicket;
import lottery.dto.RoundResult;

import java.util.List;
import java.util.stream.Collectors;

import static lottery.domain.LotteryConstants.LOTTERY_PRICE;

public class LotteryTicket implements ReadonlyLotteryTicket {

    private final List<Lottery> lotteries;

    public LotteryTicket(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<ReadonlyLottery> getLotteries() {
        return lotteries.stream()
                        .map(LotteryProxy::new)
                        .collect(Collectors.toList());
    }

    public RoundResult getResult(List<Integer> winningNumbers) {
        List<Prize> prizes = lotteries.stream()
                                      .map(lottery -> lottery.getPrize(winningNumbers))
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
