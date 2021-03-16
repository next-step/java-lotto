package study.lotto;

import study.lotto.controller.LottoGame;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;
import study.lotto.view.InputView;
import study.lotto.view.dto.RequestWinningNumber;
import study.lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        // 금액 요청
        RequestMoney requestMoney = inputView.requestMoney();

        LottoGame lottoGame = new LottoGame();
        Lottos lottos = lottoGame.buyLotto(requestMoney);

        // 중간 보기
        resultView.printBuyCount(requestMoney);
        resultView.printBuyLottos(lottos);

        RequestWinningNumber winningNumber = inputView.requestWinningNumber();
        // 결과 보기
        resultView.printStatics(winningNumber, lottoGame);
    }
}
