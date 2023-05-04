package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;


public class LottoStore {

    private final LottoGenerator lottoGenerator;
    private final Scanner scanner;

    public LottoStore(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
        this.scanner = new Scanner(System.in);
    }

    public void open(LottoBuyer lottoBuyer) {
        sellTo(lottoBuyer);

        Money winningAmount = calculateWinningAmount(lottoBuyer);

        pay(lottoBuyer, winningAmount);
    }

    private Money calculateWinningAmount(LottoBuyer lottoBuyer) {
        InputView.printInputWinningNumbers();

        Lotto winningLotto = lottoGenerator.generate(scanner.nextLine());
        Matchs matchs = checkWinning(lottoBuyer, winningLotto);

        ResultView.printWinningMatchCount(matchs);
        return matchs.calculateWinningAmount();
    }

    private Matchs checkWinning(LottoBuyer lottoBuyer, Lotto winningLotto) {
        return lottoBuyer.checkWinning(winningLotto);
    }

    private void give(LottoBuyer lottoBuyer, Lottos lottos) {
        lottoBuyer.receive(lottos);
        ResultView.printLottos(lottos);
    }

    private void pay(LottoBuyer lottoBuyer, Money winningAmount) {
        lottoBuyer.earn(winningAmount);
        ResultView.printRateOfEarning(lottoBuyer.calculateRateOfEarning());
    }

    private void sellTo(LottoBuyer lottoBuyer) {
        InputView.printInputBuyAmount();
        Money receivedMoney = receiveMoney();
        Lottos lottos = lottoGenerator.generate(receivedMoney);
        ResultView.printResultBuyCount(lottos.size());
        give(lottoBuyer, lottos);
    }

    private Money receiveMoney() {
        String buyAmount = scanner.nextLine();
        return new Money(Long.parseLong(buyAmount));
    }
}
