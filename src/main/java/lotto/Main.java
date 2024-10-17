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
        try {
            PurchasedLottos purchasedLottos = buyLottos();
            LottoMatchNumbers matchNumbers = inputMatchNumbers();
            printStatistics(matchNumbers, purchasedLottos);
        } catch (IllegalArgumentException e) {
            System.out.printf("잘못된 입력입니다: %s\n", e.getMessage());
        } catch (Exception e) {
            System.out.printf("알 수 없는 예외입니다: %s\n", e.getMessage());
        }
    }

    private static PurchasedLottos buyLottos() {
        LottoAgent lottoAgent = LottoAgent.newInstance();
        setBudget(lottoAgent);
        int manualLottoCount = buyLottosManually(lottoAgent);
        int automaticLottoCount = buyLottosAutomatically(lottoAgent);
        PurchasedLottos purchasedLottos = lottoAgent.getPurchasedLottos();
        ResultView.printPurchasedLottosCount(manualLottoCount, automaticLottoCount);
        ResultView.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private static void setBudget(LottoAgent lottoAgent) {
        int price = InputView.priceInput();
        lottoAgent.deposit(price);
    }

    private static int buyLottosManually(LottoAgent lottoAgent) {
        int manualLottoCount = InputView.manualLottoCountInput();
        List<LottoNumbers> manuallyLottoNumbersList = InputView.manualNumbersInputs(manualLottoCount);
        for (LottoNumbers manualLottoNumbers : manuallyLottoNumbersList) {
            lottoAgent.buyManually(manualLottoNumbers);
        }
        return manualLottoCount;
    }

    private static int buyLottosAutomatically(LottoAgent lottoAgent) {
        return lottoAgent.buyAutomatically(RandomSelectionStrategy.getInstance());
    }

    private static LottoMatchNumbers inputMatchNumbers() {
        List<Integer> winnerNumbers = InputView.winnerNumbersInput();
        int bonusNumber = InputView.bonusNumberInput();
        return new LottoMatchNumbers(winnerNumbers, bonusNumber);
    }

    private static void printStatistics(LottoMatchNumbers matchNumbers, PurchasedLottos purchasedLottos) {
        ResultView.printStatisticsSectionHeader();
        LottoJudge lottoJudge = LottoJudge.of(LottoNumbers.valueOf(matchNumbers.winnerNumbers), LottoNumber.valueOf(matchNumbers.bonusNumber));
        LottoRewardCountMap rewardCountMap = lottoJudge.countRewards(purchasedLottos);
        ResultView.printRewardCountMap(rewardCountMap);
        double rewardPercentage = lottoJudge.calculateRewardPercentage(purchasedLottos);
        ResultView.printPercentageRateOfReturn(rewardPercentage);
    }

    private static class LottoMatchNumbers {
        public final List<Integer> winnerNumbers;
        public final int bonusNumber;

        public LottoMatchNumbers(List<Integer> winnerNumbers, int bonusNumber) {
            this.winnerNumbers = winnerNumbers;
            this.bonusNumber = bonusNumber;
        }
    }
}
