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
import lotto.view.UserConsole;
import lotto.view.UserResult;

public class Controller {

    public static void run() {
        Money money = UserConsole.inputPurchaseAmount();

        LottoCalculation lottoCalculation = new LottoCalculation(money);
        int count = lottoCalculation.lottoCalculation();

        Lottos lottoBundle = LottoBundle.lottoBundle(count, new ShuffleLottoNumber());
        UserResult.printCountMessage(lottoBundle);
        Lotto winningLottoNumber = new Lotto(UserConsole.inputWinningLottoNumber());
        LottoNumber bonusLottoNumber = UserConsole.inputBbonusLottoNumber();

        Winning winning = new Winning(winningLottoNumber, bonusLottoNumber);
        UserResult.printRank(new RankResult(lottoBundle, winning));
        UserResult.printPrizeRatio(new RankResult(lottoBundle, winning).getTotalPrize(), money);
    }
}
