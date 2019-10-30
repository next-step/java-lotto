package step3;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static step3.InputView.*;
import static step3.ResultView.*;

public class LottoApplication {

    public static void main(String[] args) {

        Money money = new Money(InputView.inputCash());

        countLottoResult(money.getLottoCount());
        LottoGenerator.generateStandardLotto();

        // 1. 로또 구매 ( 구매한 로또 번호는 고유하다. )
        Set<Lotto> purchasedLottos = LottoGenerator.purchasedLottos(money.getLottoCount());
        Lotto.goPrint(purchasedLottos);

        // 2. 당첨번호와 보너스 번호를 입력 받음
        String[] inputWinningNumbers = inputWinningNumbers();
        LottoWinningNumbers winningNumbers = LottoWinningNumbers.creatLottoWinningNumbers(inputWinningNumbers);
        bonusNumberAdd(winningNumbers);

        // 3. 로또 당첨여부 확인
        // 3-1. 구매한 로또 각각 낱장에 당첨번호가 몇 개나 있는지 카운팅
        List<Integer> resultMatching = Lotto.lotteryStatics(purchasedLottos, LottoWinningNumbers.valueOf(winningNumbers));
        StatisticResult statisticResult = new StatisticResult(resultMatching);

        // 3-2. 보너스 볼이 일치하는지 확인
        if (statisticResult.bonusValidCheck(statisticResult)) {
            Lotto.pickOutBonusWinningLotto(purchasedLottos);
        }

        // 4. 당첨된 로또만 가져오기
        Map<Integer, Integer> summaryResult = StatisticResult.lottosInRank(resultMatching);
        printAboutRank(summaryResult);
        printYield(money.winningPrize(summaryResult));
    }
}
