package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void startLotto() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        // 로또 가격 입력
        int price = inputView.inputLottoPrice();

        // 로또 구매 갯수 출력
        int lottoCount = new Money().buyCount(price);
        resultView.printLottoCount(lottoCount);

        // 로또 초기화
        Lottos lottos = new Lottos(lottoCount);

        // 로또 번호 출력
        resultView.printLottos(lottos);

    }
}
