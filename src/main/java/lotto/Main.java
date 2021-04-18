package lotto;

import lotto.View.InputView;
import lotto.View.ResultView;
import lotto.domain.Lottos;
import lotto.domain.Statistic;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Lottos lottos = new Lottos();

        int purchaseAmount = InputView.inputPurchaseAmount();
        int purchaseNum = lottos.calculatePurchaseNum(purchaseAmount);
        ResultView.printPurchaseNum(purchaseNum);

        lottos.initializeLottoNumbers();
        String lottoNumbers = lottos.lottoNumbersToString();
        ResultView.printLottoNumbers(lottoNumbers);

        String stringWinNumbers = InputView.inputWinNumber();
        List<Integer> winNumbers = lottos.winNumbers(stringWinNumbers);
        Map<Long, Integer> doStatistic = lottos.statistic(lottos.correctNumbers(winNumbers));
        Statistic statistic = new Statistic(purchaseAmount,doStatistic);
        ResultView.printStatistics(statistic);



    }

}
