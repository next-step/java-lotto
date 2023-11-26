package step4.controller;

import step4.domain.lotto.AutomaticLottoGenerator;
import step4.domain.lotto.LottoGame;
import step4.domain.lotto.LottoNumber;
import step4.domain.lotto.LottoResult;
import step4.domain.lotto.UserLotto;
import step4.domain.lotto.WinningLotto;

import java.util.List;
import java.util.Set;

import static step4.view.InputView.automaticLottoCount;
import static step4.view.InputView.bonusNumber;
import static step4.view.InputView.manualLottoCount;
import static step4.view.InputView.manualLottoNumbers;
import static step4.view.InputView.purchaseAmount;
import static step4.view.InputView.winningLottoNumbers;
import static step4.view.OutputView.printLottoResult;
import static step4.view.OutputView.printUserLotto;

public class LottoGameController {

    public void run() {
        int purchaseAmount = purchaseAmount();
        int manualLottoCount = manualLottoCount(purchaseAmount);
        List<UserLotto> manualUserLottoList = manualLottoNumbers(manualLottoCount);
        int automaticLottoCount = automaticLottoCount(purchaseAmount, manualLottoCount);

        LottoGame lottoGame = new LottoGame();
        lottoGame.createUserLottoList(manualUserLottoList, new AutomaticLottoGenerator(automaticLottoCount));
        printUserLotto(lottoGame);

        Set<LottoNumber> winningLottoNumbers = winningLottoNumbers();
        int bonusNumber = bonusNumber(winningLottoNumbers);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, new LottoNumber(bonusNumber));

        LottoResult lottoResult = lottoGame.playLottoGame(winningLotto);
        printLottoResult(purchaseAmount, lottoResult);
    }
}
