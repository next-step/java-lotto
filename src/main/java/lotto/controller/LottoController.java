package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.result.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.domain.Lotto.stringToNumber;

public class LottoController {


    public static void main(String[] args) {

        int payment = InputView.enterAmount();

        Lottos lottos = LottoShop.buyLotto(payment);
        ResultView.printLottoCount(lottos.getLottoCount());
        ResultView.printLottoNumber(lottos);

        Lotto winningLotto = stringToNumber(InputView.enterWinningNumber());
        Integer bonusNumber = InputView.enterBonusNumber();

        LottoResult lottoResult = lottos.getLottoResult(winningLotto, bonusNumber);

        ResultView.printLottoStatistic(lottoResult);
        ResultView.printWinningProfit(lottoResult, payment);

    }
}
