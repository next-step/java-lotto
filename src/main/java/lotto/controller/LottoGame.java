package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        int money = InputView.getLottoMoney(); // 구입 금액을 입력해주세요
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.start(money);
        ResultView.printPurchaseNumber(lottos.size()); // 개를 구입했습니다.

        // TODO: Lotto 목록 출력
        ResultView.printGenerateLottos(lottos);

        List<Integer> winningLottoNumbers = InputView.getWinningNumbers(); // 당첨 번호를 입력해주세요
        int bonusBall = InputView.getBonusBall();
        WinningLotto winningLotto = WinningLotto.generate(new Lotto(winningLottoNumbers), bonusBall);

        // TODO: 로또 결과 계산
        // TODO: 로또 결과 출력
        WinningType winningResult =  lottos.result(winningLotto);
        Output.printResult(winningResult, money);
    }
}
