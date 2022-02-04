package lotto.controller;


import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoCalculation;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RankCount;
import lotto.domain.RankResult;
import lotto.domain.Winning;
import lotto.view.UserConsole;
import lotto.view.UserResult;

public class Controller {

    public static void run() {
        Money money = UserConsole.inputString();

        LottoCalculation lottoCalculation = new LottoCalculation(money);
        int count = lottoCalculation.lottoCalculation();

        Lottos lottoBundle = LottoBundle.lottoBundle(count);
        UserResult.printCountMessage(lottoBundle);

        Lotto winningLottoNumber = new Lotto(UserConsole.winningLottoNumber());
        LottoNumber bonusLottoNumber = UserConsole.bonusLottoNumber();

        RankCount rankCount = new RankCount(lottoBundle,
            new Winning(winningLottoNumber, bonusLottoNumber));

        UserResult.printRank(new RankResult(rankCount));
        UserResult.printPrizeRatio(new RankResult(rankCount).getTotalPrize(), money);
    }
}
