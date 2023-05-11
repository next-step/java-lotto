package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.result.LottoResults;
import lotto.view.InputView;
import lotto.view.ResultView;

import javax.xml.transform.Result;
import java.util.Scanner;

import static lotto.domain.Lotto.stringToNumber;

public class LottoController {


    public static void main(String[] args) {

        int payment = InputView.enterAmount();

        Lottos lottos = LottoShop.buyLotto(payment);
        ResultView.printLottoCount(lottos.getLottoCount());
        ResultView.printLottoNumber(lottos);

        Lotto winningLotto = stringToNumber(InputView.enterWinningNumber());

        LottoResults lottoResults = lottos.getLottoResult(winningLotto);
        ResultView.printLottoStatistic(lottoResults);
        ResultView.printWinningProfit(lottoResults, payment);

    }
}
