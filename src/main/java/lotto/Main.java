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
        PurchasedLottos purchasedLottos = buyLottos();
        
        List<Integer> winnerNumbers = InputView.winnerNumbersInput();
        int bonusNumber = InputView.bonusNumberInput();

        printStatistics(winnerNumbers, bonusNumber, purchasedLottos);
    }

    private static PurchasedLottos buyLottos() {
        LottoAgent lottoAgent = LottoAgent.newInstance();
        int price = InputView.priceInput();
        lottoAgent.deposit(price);
        int manualLottoCount = InputView.manualLottoCountInput();

        List<LottoNumbers> manuallyLottoNumbersList = InputView.manualNumbersInputs(manualLottoCount);
        for(LottoNumbers manualLottoNumbers :manuallyLottoNumbersList ) {
            lottoAgent.buyManually(manualLottoNumbers);
        }
        int automaticLottoCount = lottoAgent.buyAutomatically(RandomSelectionStrategy.getInstance());
        PurchasedLottos purchasedLottos = lottoAgent.getPurchasedLottos();
        ResultView.printPurchasedLottosCount(manualLottoCount, automaticLottoCount);
        ResultView.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private static void printStatistics(List<Integer> winnerNumbers, int bonusNumber, PurchasedLottos purchasedLottos) {
        LottoJudge lottoJudge = LottoJudge.of(LottoNumbers.valueOf(winnerNumbers), LottoNumber.valueOf(bonusNumber));
        ResultView.printStatisticsSectionHeader();
        LottoRewardCountMap rewardCountMap = lottoJudge.countRewards(purchasedLottos);
        ResultView.printRewardCountMap(rewardCountMap);
        double rewardPercentage = lottoJudge.calculateRewardPercentage(purchasedLottos);
        ResultView.printPercentageRateOfReturn(rewardPercentage);
    }
}
