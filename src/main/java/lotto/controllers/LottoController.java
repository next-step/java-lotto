package lotto.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domains.Lotto;
import lotto.domains.LottoGenerator;
import lotto.domains.LottoNumber;
import lotto.domains.LottoPurchasedAmount;
import lotto.domains.LottoStatistics;
import lotto.domains.LottoWinner;
import lotto.domains.UnsignedInteger;
import lotto.views.InputView;
import lotto.views.ResultView;

public class LottoController {
    public List<Lotto> purchaseLotto() {
        InputView inputView = new InputView();
        LottoGenerator lottoGenerator = new LottoGenerator();

        LottoPurchasedAmount money = LottoPurchasedAmount.of(inputView.inputPurchaseMoney());
        UnsignedInteger manualLottoCount = UnsignedInteger.parse(inputView.inputPurchaseCountByManual());
        List<String> lottoListByManual = inputView.inputLottoByManual(manualLottoCount.getValue());

        List<Lotto> manualLottoList = lottoGenerator.purchaseByManual(money, lottoListByManual);
        List<Lotto> autoLottoList = lottoGenerator.purchaseByAuto(money.spend(manualLottoCount));

        inputView.printPurchasedLottoList(manualLottoList, autoLottoList);

        return Stream
                .concat(manualLottoList.stream(), autoLottoList.stream())
                .collect(Collectors.toList());
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
