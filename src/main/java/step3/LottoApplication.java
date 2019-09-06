package step3;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static step3.InputView.*;
import static step3.ResultView.*;

public class LottoApplication {

    public static void main(String[] args) {

        LottoLottery lottery = new LottoLottery();

        int lottoCount = inputCash();
        countLottoResult(lottoCount);

        LottoGenerator.generateStandardLotto();
        Set<Lotto> purchasedLottos = LottoGenerator.purchasedLottos(lottoCount);
        printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = inputWinningNumbers1();
        List<Integer> resultMatcing = Lotto.lotteryStatics(purchasedLottos, winningNumbers);
        Map<Integer, Integer> result = Lotto.giveStatistic(resultMatcing);
        printFinalResult(result);
        double yield = lottery.calculationOfYield(lottoCount, result);
        printYield(yield);

    }
}