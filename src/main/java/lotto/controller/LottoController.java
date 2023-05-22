package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.result.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

import static lotto.domain.Lotto.getLottoCount;

public class LottoController {


    public static void main(String[] args) {

        int payment = InputView.enterAmount();
        int lottoCount = getLottoCount(payment);

        Lottos lottos = new Lottos(lottoCount);
        List<Lotto> lottoList = lottos.createLottos();

        ResultView.printLottoCount(lottoCount);
        ResultView.printLottoNumber(lottoList);

        WinningLotto winningLotto = new WinningLotto(InputView.enterWinningNumber(), InputView.enterBonusNumber());
        LottoResult lottoResult = winningLotto.getLottoResult(lottoList);

        ResultView.printLottoStatistic(lottoResult);
        ResultView.printWinningProfit(lottoResult, payment);

    }
}
