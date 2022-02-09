package lotto.controller;

import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.domain.LottoBuy;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoGame {

    public static void playLotto() {
        Lottos lottos = new Lottos();
        LottoBuy lottoBuy = new LottoBuy();

        lottoBuy.makeLottoTryCount(InputView.getMoney());
        ResultView.printCount(lottoBuy.getCount());

        lottos.makeAutoLottos(lottoBuy.getCount());
        ResultView.printLottos(lottos.getLottos());

        LottoResult lottoResult = new LottoResult(InputView.getLottoWinNumber(),
            InputView.getWinBouns());

        ResultView.printWin(WinningLotto.getMatchWin(lottos, lottoResult));

        ResultView.printProfit(lottoBuy.getMoney());
    }
}
