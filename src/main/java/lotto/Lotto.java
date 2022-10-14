package lotto;

import java.util.List;
import java.util.Scanner;

import lotto.dto.LottoResultAggregation;
import lotto.model.LottoMatchResults;
import lotto.model.LottoNumbers;
import lotto.model.LottoReward;
import lotto.model.WinningNumber;
import lotto.view.GeneratedLottoNumberResponseView;
import lotto.view.LottoResultAggregationResponseView;
import lotto.view.LottoYieldResponseView;

public class Lotto {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int paymentAmount = getPaymentAmount();
        int lottoQuantity = LottoVendingMachine.calculate(paymentAmount);
        showBuyResult(lottoQuantity);

        // create Lotter numbers
        LottoNumbers lottoNumbers = LottoVendingMachine.buy(lottoQuantity);

        showGeneratedLottoNumbers(lottoNumbers.getLottoNumbers());

        WinningNumber winningNumber = getWinningNumber();

        System.out.println("당첨통계");
        System.out.println("------------------");
        LottoMatchResults lottoMatchResults = new LottoMatchResults(lottoNumbers.guess(winningNumber));
        LottoResultAggregation lottoResultAggregation = new LottoResultAggregation(lottoMatchResults.rewardableAggregate());

        showLottoResultAggregation(lottoResultAggregation);
        showLottoYield(paymentAmount, lottoMatchResults.sumRewardAmount());
    }

    private static int getPaymentAmount() {
        System.out.println("구입금액을 입력해주세요.");

        int paymentAmount = scanner.nextInt();
        scanner.nextLine();
        return paymentAmount;
    }

    private static void showBuyResult(int lottoQuantity) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoQuantity));
    }

    private static void showGeneratedLottoNumbers(List<List<Integer>> lottoNumbers) {
        System.out.println(new GeneratedLottoNumberResponseView(lottoNumbers).toView());
    }

    private static WinningNumber getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return WinningNumber.from(scanner.nextLine());
    }

    private static void showLottoResultAggregation(LottoResultAggregation lottoResultAggregation) {
        for (LottoReward lottoReward : LottoReward.getValuesOrderByMatchResult()) {
            System.out.println(new LottoResultAggregationResponseView(lottoReward, lottoResultAggregation.rewardMatchCount(lottoReward)).toView());
        }
    }

    private static void showLottoYield(int paymentAmount, int rewardAmount) {
        System.out.println(new LottoYieldResponseView(new LottoYield(paymentAmount, rewardAmount)).toView());
    }
}
