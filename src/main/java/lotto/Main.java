package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        //구매 금액 입력 후 로또 번호 생성
        InputView inputView = new InputView();
        List<Lotto> lottos = inputView.buyTicket();

        //생성된 로또 번호 표시
        ResultView resultView = new ResultView();
        resultView.issuedTicket(lottos);

        //당첨 번호 입력
        WinningLotto winningLotto = inputView.winningLottoInput();
        LottoCenter lottoCenter = new LottoCenter(winningLotto);

        //당첨 확인
        lottoCenter.matchWinningNumbers(lottos);

        //통계 산출
        List<Integer> result = lottoCenter.checkWinningResult();
        float rate = lottoCenter.checkWinningRate();

        //통계 출력
        resultView.finalResult(result, rate);
    }
}
