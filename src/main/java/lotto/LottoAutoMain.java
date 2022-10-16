package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoAutoMain {
    public static void main(String[] args) {
        Money buyAmount = new Money(InputView.enterBuyPrice());
        LottoMachine lottoMachine = new LottoMachine(new LottoAutoCalculateStrategy());
        List<List<LottoNumber>> lottoes = lottoMachine.buyLottoes(buyAmount);
        OutputView.printLottoes(lottoes);

        List<LottoNumber> winningLottoes = InputView.enterWinningLottoes()
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Statistics statistics = lottoMachine.calculateStatistics(lottoes, winningLottoes, buyAmount);
        OutputView.printStatistics(statistics);
    }
}
