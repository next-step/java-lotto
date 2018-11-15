import domain.*;

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

        LottoGame lotto = new LottoGame(calculateAmount(totalPurchaseMoney), manualPurchaseAmount, new RandomNumberGenerator());
        lotto.generateByManual(printManualPurchaseNumber(manualPurchaseAmount));

        printLottoAmount(manualPurchaseAmount, lotto.calculateAutoPurchaseAmount());

        List<Attempt> lottoNumbers = lotto.getLottoNumbers();
        printLottoNumber(lottoNumbers);

        List<LottoNo> winnerNumbers = printLastWeekWinNumber();

        int bonusNumber = printBonusNumber(winnerNumbers);
        lotto.calculateAllRank(new LottoWinningNo(winnerNumbers,bonusNumber));

        printResultNotice();

        RankAmount rankLongMap = new RankAmount(lottoNumbers);
        printRankAmount(rankLongMap);

        float yield = rankLongMap.calculateYield(totalPurchaseMoney);
        printResultYield(yield);
    }
}
