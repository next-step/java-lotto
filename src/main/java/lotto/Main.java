package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        LottoCenter lottoCenter = new LottoCenter();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        //구매 금액 입력 후 로또 번호 생성
        List<Lotto> lottos = inputView.buyTicket();

        //생성된 로또 번호 표시
        resultView.issuedTicket(lottos);

        //당첨 번호 입력
        Lotto winningNumbers = inputView.winningNumberInput();

        //당첨 확인
        lottoCenter.matchWinningNumber(lottos, winningNumbers);

        //통계 산출
        List<Long> result = lottoCenter.checkWinningResult(lottos);
        float rate = lottoCenter.checkWinningRate();

        //통계 출력
        resultView.finalResult(result, rate);
    }
}
