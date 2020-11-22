package lotto;

import lotto.domain.*;
import lotto.service.LottoVendingMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigInteger;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int lottoPurchaseCost = InputView.inputPrice();
        List<Lotto> manualLotto = InputView.inputManualLottoNumber();

        Lottos lottos = LottoVendingMachine.buyLottery(manualLotto,lottoPurchaseCost);

        ResultView.printLottoResult(lottos);

        String lottoNumber = InputView.inputLottoNumber();
        int bonusNumber = InputView.inputBonusLottoNumber();

        List<LottoResult> lottoResults
                = LottoVendingMachine.lottoWinningResults(lottos,lottoNumber,bonusNumber);

        LottoWinningResults winningResults = LottoWinningStatistics.getStatistics(lottoResults);
        BigInteger profit =  LottoWinningStatistics.getProfit(winningResults);

        ResultView.printLottoWinningStatistics(winningResults,lottoPurchaseCost,profit);
    }
}
