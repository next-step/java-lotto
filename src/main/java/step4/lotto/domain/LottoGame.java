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
        int money = inputLottoView.inputMoney();
        // 로또 수동처리
        int manualCount = inputLottoView.inputManualCount();

        // 돈에 해당하는 로또 갯수 구하기
        LottoCount lottoCount = new LottoCount(money, manualCount);
        //로또 수동 입력
        List<String> manualLotto = inputLottoView.inputManualNumber(manualCount);

        // 로또 생성
        Lottos lottos = new Lottos();
        lottos.createManualLottos(manualLotto);
        lottos.createAutoLottos(lottoCount.autoCount().getCount());

        // 당첨 번호 입력
        WinningLotto winningLotto = new WinningLotto(
                StringUtil.stringToList(inputLottoView.inputWinningLotto()) ,
                inputLottoView.inputBonusNumber());

    }


    public Rank match(Lotto userLotto, WinningLotto winningLotto){
        return winningLotto.match(userLotto);
    }
}
