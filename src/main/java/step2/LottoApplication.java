package step2;

import java.util.*;

import static step2.InputView.*;

public class LottoApplication {

    public static void main(String[] args) {

        ResultView resultView = new ResultView();
        Lotto lotto = new Lotto();
        LottoLottery lottery = new LottoLottery();

        int lottoCount = inputCash();
        resultView.countLottoResult(lottoCount);

        List<Integer> standardLotto = lotto.generateStandardLotto();
        Set<ArrayList<Integer>> purchasedLottos = lotto.purchasedLottos(standardLotto, lottoCount);
        resultView.printPurchasedLottos(purchasedLottos);

        int[] winningNumbers = inputWinningNumbers();
        List<Integer> resultMatcing = lottery.lotteryStatics(purchasedLottos, winningNumbers);
        Map<Integer, Integer> result = lottery.giveStatistic(resultMatcing);
        resultView.printFinalResult(result);
        double yield = lottery.calculationOfYield(lottoCount, result);
        resultView.printYield(yield);

    }


}