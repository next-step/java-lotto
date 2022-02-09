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

public class LottoController {

    private LottoController() {
    }

    public static void run() {
        Money money = UserConsole.inputString();

        Lottos lottos = generateLottoBundle(money);
        UserResult.printLottoBundle(lottos);

        Lotto winningLottoNumber = winningLottoNumberInput();
        LottoNumber bonusLottoNumber = UserConsole.bonusLottoNumber();

        RankCount rankCount = lottoRankCount(lottos, winningLottoNumber, bonusLottoNumber);
        LottoResult(money, rankCount);
    }

    private static Lottos generateLottoBundle(Money money) {
        Lottos lottoBundle = LottoBundle.lottoBundle(
            calculationLottoCount(makeLottoCalculation(money)));
        return lottoBundle;
    }

    private static int calculationLottoCount(LottoCalculation lottoCalculation) {
        int count = lottoCalculation.lottoCalculation();
        return count;
    }

    private static Lotto winningLottoNumberInput() {
        Lotto winningLottoNumber = new Lotto(UserConsole.winningLottoNumber());
        return winningLottoNumber;
    }

    private static RankCount lottoRankCount(Lottos lottoBundle, Lotto winningLottoNumber,
        LottoNumber bonusLottoNumber) {
        return new RankCount(lottoBundle, new Winning(winningLottoNumber, bonusLottoNumber));
    }

    private static void LottoResult(Money money, RankCount rankCount) {
        UserResult.printRank(rankResult(rankCount));
        UserResult.printPrizeRatio(lottoTotalPrize(rankCount), money);
    }

    private static RankResult rankResult(RankCount rankCount) {
        return new RankResult(rankCount);
    }

    private static Money lottoTotalPrize(RankCount rankCount) {
        return new RankResult(rankCount).getTotalPrize();
    }

    private static LottoCalculation makeLottoCalculation(Money money) {
        LottoCalculation lottoCalculation = new LottoCalculation(money);
        return lottoCalculation;
    }
}

