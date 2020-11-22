package lotto;

import lotto.domain.*;
import lotto.service.LottoVendingMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigInteger;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int price = InputView.inputPrice();
        Lottos lottos = LottoVendingMachine.buyAutoLottery(price);

        ResultView.printLottoResult(lottos);

        String lottoNumber = InputView.inputLottoNumber();
        int bonusNumber = InputView.inputBonusLottoNumber();

        List<LottoResult> lottoResults
                = LottoVendingMachine.lottoWinningResults(lottos,lottoNumber,bonusNumber);

        LottoWinningResults winningResults = LottoWinningStatistics.getStatistics(lottoResults);
        BigInteger profit =  LottoWinningStatistics.getProfit(winningResults);

        ResultView.printLottoWinningStatistics(winningResults,price,profit);
    }
}
