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

        // 1. 로또 구매 ( 구매한 로또 번호는 고유하다. )
        Set<Lotto> purchasedLottos = LottoGenerator.purchasedLottos(lottoCount);
        printPurchasedLottos(purchasedLottos);

        // 2. 당첨번호와 보너스 번호를 입력 받음
        List<Integer> winningNumbers = inputWinningNumbers();
        bonusNumberAdd(winningNumbers);

        // 3. 로또 당첨여부 확인
        // 3-1. 구매한 로또 각각 낱장에 당첨번호가 몇 개나 있는지 카운팅
        List<Integer> resultMatching = Lotto.lotteryStatics(purchasedLottos, winningNumbers);
        Map<Integer, Integer> result = Lotto.giveStatistic(resultMatching); // key: purchasedLottos의 인덱스, value: 몇 개 일치하는지

        // 3-2. 보너스 볼이 일치하는지 확인: n개 일치하는 것이 각각 몇개인지 result에 저장되어있음
        if (result.get(LottoGenerator.BONUS_WINNING_VALID_NUMBER) > 0){
            // 1) 당첨번호 5개 일치하는 로또의 인덱스 값
            lottery.checkBonusWinningChance(resultMatching);
            // 2) 당첨번호 5개 일치하는 로또가 보너스번호도 일치하는지 확인 > 5개 + 보너스볼 일치하는 것 count
            lottery.pickOutBonusWinningLotto(purchasedLottos);
        }

        printFinalResult(result);

        double yield = Math.abs(lottery.calculationOfYield(lottoCount, result));
        printYield(yield);

    }

}
