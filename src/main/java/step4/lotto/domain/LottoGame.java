package step4.lotto.domain;

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

        // 수동처리가 로또 카운트보다 작아야함
        // 수동 입력 횟수
        // 로또 자동 생성
        Lottos lottos = new Lottos();


        // 입력값 처리 ( 금액, 자동생성 숫자, 수동 생성 번호)
        // 로또 번호 입력
        // 당첨 번호 입력
        // 보너스번호 입력

        //통계

    }


    public Rank match(List<Integer> userLotto, WinningLotto winningLotto){
        return winningLotto.match(userLotto);
    }
}
