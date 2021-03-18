package lottery.domain;

import lottery.dto.RoundResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lottery.domain.LotteryTicketIssuer.LOTTERY_PRICE;

public class LotteryTicket {

    private final List<Lottery> lotteries;

    public LotteryTicket(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lottery> getLotteries() {
        return Collections.unmodifiableList(lotteries);
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
