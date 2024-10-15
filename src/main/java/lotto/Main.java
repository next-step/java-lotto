package lotto;

import lotto.domain.LottoAgent;
import lotto.domain.LottoJudge;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRewardCountMap;
import lotto.domain.PurchasedLottos;
import lotto.domain.RandomSelectionStrategy;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int price = InputView.priceInput();
        LottoAgent lottoAgent = LottoAgent.newInstance();
        lottoAgent.buy(price, RandomSelectionStrategy.getInstance());
        PurchasedLottos purchasedLottos = lottoAgent.getPurchasedLottos();
        ResultView.printPurchasedLottos(purchasedLottos);

        List<Integer> winnerNumbers = InputView.winnerNumbersInput();
        int bonusNumber = InputView.bonusNumberInput();
        LottoJudge lottoJudge = LottoJudge.of(LottoNumbers.valueOf(winnerNumbers), LottoNumber.valueOf(bonusNumber));

        ResultView.printStatisticsSectionHeader();
        LottoRewardCountMap rewardCountMap = lottoJudge.countRewards(purchasedLottos);
        ResultView.printRewardCountMap(rewardCountMap);
        double rewardPercentage = lottoJudge.calculateRewardPercentage(purchasedLottos);
        ResultView.printPercentageRateOfReturn(rewardPercentage);
    }
}
