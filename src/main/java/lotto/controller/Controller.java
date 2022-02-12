package lotto.controller;


import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoCalculation;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.domain.ShuffleLottoNumber;
import lotto.domain.Winning;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public static void run() {
        Money money = new Money(InputView.inputPurchaseAmount());
        int count = calculateLottoCount(money);
        Lottos lottoBundle = generateLottoNumber(count);
        Lotto winningLottoNumber = new Lotto(InputView.inputWinningLottoNumber());
        LottoNumber bonusLottoNumber = InputView.inputBonusLottoNumber();
        Winning winning = new Winning(winningLottoNumber, bonusLottoNumber);
        RankResult rankResult = new RankResult(lottoBundle, winning);
        showLottoResult(money, rankResult);
    }

    private static void showLottoResult(Money money, RankResult rankResult) {
        OutputView.printRank(rankResult);
        OutputView.printPrizeRatio(money.getPrizeRatio(rankResult.getTotalPrize(), money));
    }

    private static Lottos generateLottoNumber(int count) {
        Lottos lottoBundle = LottoBundle.lottoBundle(count, new ShuffleLottoNumber());
        OutputView.printCountMessage(lottoBundle);
        return lottoBundle;
    }

    private static int calculateLottoCount(Money money) {
        LottoCalculation lottoCalculation = new LottoCalculation(money);
        int count = lottoCalculation.lottoCalculation();
        return count;
    }
}
