package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.domain.LottoGenerator.generateLottos;

public class LottoController {

    public void buyLotto() {
        // 금액만큼 Lotto 생성 하여 출력
        LottoFee lottoFee = InputView.payForGames();
        Lottos lottos = generateLottos(lottoFee);
        ResultView.showLottos(lottos);

        // 당첨 번호 및 보너스 번호 입력 받아 WinningLotto 생성
        Lotto winningNumber = Lotto.from(InputView.inputWinningNumber());
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLottoNumber = new WinningLotto(winningNumber, bonusNumber);

        // 당첨 번호 확인 후 출력
        ResultView.showRanks(lottos.match(winningLottoNumber), lottoFee);
    }
}
