import domain.*;

import java.util.ArrayList;
import java.util.List;

import static domain.Money.calculateAmount;
import static util.Validation.validatePurchaseAmount;
import static util.Validation.validatePurchaseMoney;
import static view.InputView.*;
import static view.OutputView.*;

public class Main {
    public static void main(String[] args) {
        int totalPurchaseMoney = getPurchaseAmount();
        validatePurchaseMoney(totalPurchaseMoney);

        int manualPurchaseAmount = getManualPurchaseAmount();
        validatePurchaseAmount(manualPurchaseAmount);

        Lotto lotto = new Lotto(calculateAmount(totalPurchaseMoney), manualPurchaseAmount, new RandomNumberGenerator());
        lotto.generateByManual(printManualPurchaseNumber(manualPurchaseAmount));

        printLottoAmount(manualPurchaseAmount, lotto.calculateAutoPurchaseAmount());

        List<Attempt> lottoNumbers = lotto.getLottoNumbers();
        printLottoNumber(lottoNumbers);

        List<Integer> winnerNumbers = printLastWeekWinNumber();

        int bonusNumber = printBonusNumber(winnerNumbers);
        lotto.calculateAllRank(winnerNumbers, bonusNumber);

        printResultNotice();

        RankAmount rankLongMap = new RankAmount(lottoNumbers);
        printRankAmount(rankLongMap);

        float yeild = rankLongMap.calculateYeild(totalPurchaseMoney);
        printResultYield(yeild);
    }
}
