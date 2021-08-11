package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.RandomNumber;
import lotto.view.InputView;
import lotto.view.ResultView;


public class LottoController {
    public void playLotto() {
        int lottoCount = InputView.buyLotto();

        for(int i=0; i<lottoCount; i++){
            Lotto lotto = new Lotto(RandomNumber.makeLottoNumbers());
            ResultView.printLotto(lotto);
        }

        String winningNumber = InputView.inputWinningNumber();
        System.out.println(winningNumber);
    }
}
