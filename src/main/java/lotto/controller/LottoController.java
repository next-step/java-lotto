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

    private static InputView inputView = new InputView();

    public static void main(String[] args) {


        int payment = inputView.enterAmount();
        int menualCount = inputView.enterMenualCount();

        List<Lotto> lottoList = inputView.enterMenualNumbers(menualCount);

        int lottoCount = getLottoCount(payment);
        int automaticCount = lottoCount - menualCount;

        Lottos lottos = new Lottos(automaticCount);
        lottoList.addAll(lottos.createLottos());

        ResultView.printLottoCount(menualCount, automaticCount);
        ResultView.printLottoNumber(lottoList);

        WinningLotto winningLotto = new WinningLotto(inputView.enterWinningNumber(), inputView.enterBonusNumber());
        LottoResult lottoResult = winningLotto.getLottoResult(lottoList);

        ResultView.printLottoStatistic(lottoResult);
        ResultView.printWinningProfit(lottoResult, payment);

    }
}
