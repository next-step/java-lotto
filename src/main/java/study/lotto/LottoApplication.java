package study.lotto;

import study.lotto.controller.LottoStore;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.LottoResult;
import study.lotto.domain.WinningLotto;
import study.lotto.service.Lottos;
import study.lotto.view.ResultView;
import study.lotto.view.dto.RequestMoney;

import static study.lotto.view.InputView.*;
import static study.lotto.view.ResultView.printRate;
import static study.lotto.view.ResultView.printResult;


public class LottoApplication {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();

        RequestMoney requestMoney = money();
        ResultView.printLottoCount(requestMoney);
        Lottos lottos = lottoStore.lotto(requestMoney);

        ResultView.printLottos(lottos);

        Lotto winningNumber = winningNumber();
        LottoNumber bonusNumber = bonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);

        printResult(lottoResult);
        printRate(lottoResult);
    }
}
