package study.lotto;

import study.lotto.controller.LottoStore;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.LottoResult;
import study.lotto.domain.Money;
import study.lotto.view.dto.ManualLottoParser;
import study.lotto.domain.WinningLotto;
import study.lotto.service.Lottos;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;
import study.lotto.view.dto.RequestLottoArgument;


public class LottoApplication {

    public void step4() {
        InputView inputView = new InputView();
        LottoStore lottoStore = new LottoStore();
        ResultView resultView = new ResultView();

        Money money = Money.of(inputView.requestPurchasedLotto());
        String manualCount = inputView.requestManual();
        RequestLottoArgument lottoArgument = RequestLottoArgument.of(money, manualCount);

        ManualLottoParser manualArgument = ManualLottoParser.of(inputView.makeManualLottoNumbers(manualCount));
        resultView.printLottoCount(lottoArgument);

        Lottos lottos = lottoStore.issueLotto(lottoArgument, manualArgument);
        resultView.printLottos(lottos);

        String winningNumbers = inputView.requestWinningNumbers();
        LottoNumber bonusNumber = LottoNumber.of(inputView.requestBonusNumber());

        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

        LottoResult lottoResult = LottoResult.of(lottos, winningLotto);
        resultView.printResult(lottoResult);
    }

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        lottoApplication.step4();
    }
}
