package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;


public class LottoStore {

    public static final Money LOTTO_AMOUNT = new Money(1_000L);
    private final LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void open(LottoBuyer lottoBuyer) {
        Scanner scanner = new Scanner(System.in);

        InputView.printInputBuyAmount();
        Money sellAmount = sellTo(lottoBuyer);
        long countOfLotto = calculateCountOfLotto(sellAmount);
        ResultView.printResultBuyCount(countOfLotto);


        Lottos lottos = lottoGenerator.generate(countOfLotto);
        give(lottoBuyer, lottos);
        ResultView.printLottos(lottos);

        InputView.printInputWinningNumbers();
        Lotto winningLotto = lottoGenerator.generate(scanner.nextLine());

        Matchs matchs = lottoBuyer.checkWinning(winningLotto);
        ResultView.printWinningMatchCount(matchs);

        pay(lottoBuyer, matchs);
        ResultView.printRateOfEarning(lottoBuyer.calculateRateOfEarning());
    }

    private void give(LottoBuyer lottoBuyer, Lottos lottos) {
        lottoBuyer.receive(lottos);
    }

    private void pay(LottoBuyer lottoBuyer, Matchs matchs) {
        lottoBuyer.earn(matchs.calculateWinningAmount());
    }

    private Money sellTo(LottoBuyer lottoBuyer) {
        return lottoBuyer.buy();
    }

    private long calculateCountOfLotto(Money amount) {
        return (long) amount.divide(LOTTO_AMOUNT);
    }
}
