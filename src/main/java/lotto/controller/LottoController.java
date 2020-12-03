package lotto.controller;

import lotto.domain.Lottoes;
import lotto.domain.WinningNumbers;
import lotto.view.LottoGameView;
import lotto.view.input.InputView;

public class LottoController {

    public Lottoes purchaseLotto() {
        //구입금액 입력
        //수동으로 구매할 로또 수(LottoCount)(view)
        //번호 입력 x 로또 수
        //return List<String>
        //new Lottoes(List<String>, Amount());
        Lottoes lottoes = new Lottoes(LottoGameView.enterLottoAmount());

        LottoGameView.printLottoNumbers(lottoes);
        return lottoes;
    }

    public void getLottoGameResult(Lottoes lottoes) {
        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers(), InputView.enterBonusNumber());
        LottoGameView.printResult(lottoes.getResult(winningNumbers));
    }
}
