package service;

import generator.RandomNumberGenerator;
import model.Lotto;
import model.LottoResult;
import model.LottoShop;
import ui.InputView;
import ui.ResultView;

import java.util.List;

public class LottoService {
    public void play() {
        int payAmount = InputView.getPayAmount();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoShop lottoShop = new LottoShop(randomNumberGenerator);
        List<Lotto> paidLottoList = lottoShop.generateLotto(payAmount);

        ResultView.printLottoNumbers(paidLottoList);

        Lotto winningLotto = InputView.getLastWeekWinNumber();
        LottoResult result = LottoResult.of(winningLotto, paidLottoList, payAmount);

        ResultView.printLottoResults(result);
    }

}
