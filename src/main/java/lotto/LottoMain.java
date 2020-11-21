package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.Lottos;
import lotto.service.LottoVendingMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoMain {

    public static void main(String[] args) {
        int price = InputView.inputPrice();
        Lottos lottos = LottoVendingMachine.buyAutoLottery(price);

        ResultView.printLottoResult(lottos);

        String lottoNumber = InputView.inputLottoNumber();
        int bonusNumber = InputView.inputBonusLottoNumber();

        List<LottoResult> lottoResults = LottoVendingMachine.lottoWinningResults(lottos,lottoNumber,bonusNumber);

        Map<LottoResult, AtomicInteger> statistics = LottoWinningStatistics.getStatistics(lottoResults);

        BigInteger profit =  LottoWinningStatistics.getProfit(statistics);

        ResultView.printLottoWinningStatistics(statistics,price,profit);
    }
}
