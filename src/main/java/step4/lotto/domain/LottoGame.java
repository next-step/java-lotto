package step4.lotto.domain;

import lotto.util.StringUtil;
import step4.lotto.view.InputLottoView;
import step4.lotto.view.ResultInputView;

import java.util.List;

public class LottoGame {
    private final InputLottoView inputLottoView;
    private final ResultInputView resultInputView;

    public LottoGame() {
        this.inputLottoView = new InputLottoView();
        this.resultInputView = new ResultInputView();
    }

    public void run() {
        // 로또 금액입력
        Money money = new Money(inputLottoView.inputMoney());

        // 로또 수동처리
        int manualCount = inputLottoView.inputManualCount();

        //로또 수동 입력
        List<String> manualLotto = inputLottoView.inputManualNumber(manualCount);

        Lottos lottos = new Lottos();
        lottos.addLotto(money.lottoCount() - manualCount);
        lottos.addLotto(manualLotto);

       // 당첨
        resultInputView.displayLotto(money.lottoCount() ,manualCount, lottos.toString());

        WinningLotto winningLotto = new WinningLotto(
                StringUtil.stringToList(inputLottoView.inputWinningLotto()) ,
                inputLottoView.inputBonusNumber());

        Result result = lottos.match(winningLotto);

        resultInputView.displayResultTitle();
        resultInputView.display(result.displayResult());
        resultInputView.display(money.profits(result.prize()));


    }


}
