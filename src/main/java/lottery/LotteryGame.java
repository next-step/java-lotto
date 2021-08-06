package lottery;

import lottery.domain.creatingstrategy.RandomCreatingLotteryStrategy;
import lottery.domain.Lotteries;
import lottery.domain.Lottery;
import lottery.domain.LotteryNumber;
import lottery.domain.Money;
import lottery.domain.winningstrategy.MatchWinningLotteryStrategy;
import lottery.dto.LotteryDto;
import lottery.dto.LotteryStatisticDto;
import lottery.view.LotteriesConsoleOutput;
import lottery.view.LotteryStatisticConsoleOutput;
import lottery.view.PurchasingPriceConsoleInput;
import lottery.view.WinningLotteryNumberConsoleInput;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryGame {

    public static void main(String[] args) {
        Money purchasingPrice = getPurchasingPrice();
        Lotteries lotteries = getLotteries(purchasingPrice);
        printLotteries(getLotteriesDto(lotteries));
        Lottery winningLottery = getWinningLottery();
        printLotteryStatistic(getLotteryStatisticDto(lotteries, winningLottery));
    }

    private static LotteryStatisticDto getLotteryStatisticDto(final Lotteries lotteries, final Lottery winningLottery) {
        return lotteries.getLotteryStatisticDto(new MatchWinningLotteryStrategy(winningLottery));
    }

    private static List<LotteryDto> getLotteriesDto(final Lotteries lotteries) {
        return lotteries.getLotteriesDto();
    }

    private static void printLotteryStatistic(LotteryStatisticDto lotteryStatistic) {
        new LotteryStatisticConsoleOutput().printLotteryStatistic(lotteryStatistic);
    }

    private static void printLotteries(List<LotteryDto> lotteryDtos) {
        new LotteriesConsoleOutput().printLotteries(lotteryDtos);
    }

    private static Money getPurchasingPrice() {
        return new Money(PurchasingPriceConsoleInput.askPurchasingPrice());
    }

    private static Lotteries getLotteries(Money purchasingPrice) {
        return new RandomCreatingLotteryStrategy().getLotteries(purchasingPrice);
    }

    private static Lottery getWinningLottery() {
        return new Lottery(getWinningLotteryNumbers());
    }

    private static List<LotteryNumber> getWinningLotteryNumbers() {
        return WinningLotteryNumberConsoleInput.askWinningLotteryNumbers()
                .stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

}
