package lotto.auto;

import lotto.*;

import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoMain {
    public static void main(String[] args) {
        Money buyAmount = new Money(InputView.enterBuyPrice());
        LottoMachine lottoMachine = new LottoMachine(new AutoLottoCalculateStrategy());
        List<SelectedLottoes> lottoes = lottoMachine.buyLottoes(buyAmount);
        OutputView.printLottoes(lottoes);

        LottoWinningStrategy winningLottoes = new AutoWinningLottoes(
                InputView.enterWinningLottoes()
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        LottoNumber bonusLotto = new LottoNumber(InputView.enterBonusBall());
        Statistics statistics = lottoMachine.calculateStatistics(lottoes, winningLottoes, buyAmount);
        OutputView.printStatistics(statistics);
    }
}
