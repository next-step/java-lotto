package lotto.controllers;

import java.util.List;
import lotto.domains.Lotto;
import lotto.domains.LottoGenerator;
import lotto.domains.LottoNumber;
import lotto.domains.LottoPurchasedAmount;
import lotto.domains.LottoStatistics;
import lotto.domains.LottoWinner;
import lotto.views.InputView;
import lotto.views.ResultView;

public class LottoController {
    public List<Lotto> purchaseLotto() {
        InputView inputView = new InputView();
        LottoGenerator lottoGenerator = new LottoGenerator();

        LottoPurchasedAmount money = LottoPurchasedAmount.of(inputView.inputPurchaseMoney());
        List<Lotto> lottoList = lottoGenerator.purchaseByAuto(money);

        inputView.printPurchasedLottoList(lottoList);

        return lottoList;
    }

    public LottoWinner drawLottery() {
        InputView inputView = new InputView();

        Lotto lastWinnerLotto = Lotto.createByString(inputView.inputLastWinner());
        LottoNumber bonusNumber = LottoNumber.of(inputView.inputBonusNumber());

        return new LottoWinner(lastWinnerLotto, bonusNumber);
    }

    public void play(List<Lotto> lottoList, LottoWinner winner) {
        ResultView resultView = new ResultView();
        resultView.printStatistics(new LottoStatistics(lottoList, winner));
    }
}
