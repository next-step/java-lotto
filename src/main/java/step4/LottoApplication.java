package step4;

import java.util.Map;
import java.util.Set;

import static step4.InputView.bonusNumberAdd;
import static step4.InputView.*;
import static step4.LottoNumber.createLottoNumber;
import static step4.ResultView.*;

public class LottoApplication {

    public static void main(String[] args) {

        Money money = new Money(inputCash());
        int manualLottoCount = inputManual();
        int autoLottoCount = money.getLottoCount() - manualLottoCount;

        // 0. 로또 수동구매(수동번호입력)
        Set<Lotto> manualLottos = inputManualLottoNumbers(manualLottoCount);
        countLottoResult(manualLottoCount, autoLottoCount);

        LottoGenerator.generateStandardLotto();

        // 1. 로또 자동구매 ( 구매한 로또 번호는 고유하다. )
        Set<Lotto> autoLottos = LottoGenerator.purchasedLottos(autoLottoCount);
        Set<Lotto> purchasedLottos = Lotto.mergeLottoSets(manualLottos, autoLottos);
        goPrint(purchasedLottos);

        // 2. 당첨번호와 보너스 번호를 입력 받음
        String[] inputWinningNumbers = inputWinningNumbers();
        Lotto lotto = createLottoNumber(inputWinningNumbers);
        bonusNumberAdd(lotto);

        // 3. 로또 당첨여부 확인
        // 3-1. 구매한 로또 각각 낱장에 당첨번호가 몇 개나 있는지 카운팅
        Lotto resultMatching = new Lotto(Lotto.lotteryStatics(purchasedLottos, lotto));
        StatisticResult statisticResult = new StatisticResult(Lotto.valueOf(resultMatching));

        // 3-2. 보너스 볼이 일치하는지 확인
        if (statisticResult.bonusValidCheck(statisticResult)) {
            Lotto.pickOutBonusWinningLotto(purchasedLottos);
        }

        // 4. 당첨된 로또만 가져오기
        Map<Integer, Integer> summaryResult = StatisticResult.lottosInRank(Lotto.valueOf(resultMatching));
        printAboutRank(summaryResult);
        printYield(money.winningPrize(summaryResult));
    }
}
