import domain.*;

import java.util.List;

import static domain.Money.calculateAmount;
import static util.Validation.validatePurchaseAmount;
import static util.Validation.validatePurchaseMoney;
import static view.InputView.*;
import static view.OutputView.*;

public class Main {
    public static void main(String[] args) {
        Money totalPurchaseMoney = Money.from(getPurchaseAmount());
        validatePurchaseMoney(totalPurchaseMoney);

        LottoAmount manualPurchaseAmount = LottoAmount.from(getManualPurchaseAmount());
        validatePurchaseAmount(manualPurchaseAmount);

        LottoGame lotto = LottoGame.from(calculateAmount(totalPurchaseMoney), manualPurchaseAmount, new RandomNumberGenerator());
        lotto.generateByManual(printManualPurchaseNumber(manualPurchaseAmount));

        printLottoAmount(manualPurchaseAmount, lotto.calculateAutoPurchaseAmount());

        List<Lotto> lottoNumbers = lotto.getLottoNumbers();
        printLottoNumber(lottoNumbers);

        List<LottoNo> winnerNumbers = printLastWeekWinNumber();

        LottoNo bonusNumber = LottoNo.from(printBonusNumber(winnerNumbers));
        lotto.calculateAllRank(LottoWinning.from(winnerNumbers, bonusNumber));

        printResultNotice();

        RankAmount rankLongMap = RankAmount.from(lottoNumbers);
        printRankAmount(rankLongMap);

        float yield = rankLongMap.calculateYield(totalPurchaseMoney);
        printResultYield(yield);
    }
}
