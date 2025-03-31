package service;

import generator.RandomNumberGenerator;
import model.lotto.*;
import ui.InputView;
import ui.ResultView;

import java.util.List;

public class LottoService {
    public void play() {
        int payAmount = InputView.getPayAmount();
        int manualCount = InputView.getManualLottoCount();
        List<Lotto> manualLotto = InputView.getManualLottoList(manualCount);
        LottoCount lottoCount = new LottoCount(payAmount, manualCount);

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoShop lottoShop = new LottoShop(randomNumberGenerator);
        List<Lotto> paidLottoList = lottoShop.generateLotto(lottoCount, manualLotto);

        ResultView.printLottoNumbers(paidLottoList);

        WinningLotto winningLotto= InputView.getLastWeekWinNumber();
        LottoResult result = LottoResult.of(winningLotto, paidLottoList, payAmount);

        ResultView.printLottoResults(result, lottoCount);
    }

}
