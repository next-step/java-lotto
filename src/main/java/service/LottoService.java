package service;

import generator.RandomNumberGenerator;
import model.lotto.*;
import ui.InputView;
import ui.ResultView;

public class LottoService {
    public void play() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Price payAmount = InputView.getPayAmount();
        LottoShop lottoShop = new LottoShop(randomNumberGenerator);

        Lottos lottos = lottoShop.generateLotto(payAmount);
        lottos.getAllLottoNumbers();
        WinningLotto winningLotto = InputView.getLastWeekWinNumber();
        LottoResult result = LottoResult.of(winningLotto, lottos, payAmount);

        ResultView.printLottoResults(result);
    }

}
