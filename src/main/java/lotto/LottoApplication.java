package lotto;

import java.util.Scanner;

import lotto.dto.LottoResultAggregation;
import lotto.model.LottoMatchResults;
import lotto.model.LottoNumbers;
import lotto.model.LottoReward;
import lotto.model.WinningNumber;
import lotto.view.BuyResultResponseView;
import lotto.view.GeneratedLottoResponseView;
import lotto.view.LottoResultAggregationResponseView;
import lotto.view.LottoYieldResponseView;
import lotto.view.MatchResultTitle;
import lotto.view.PaymentAmountInputView;
import lotto.view.WinningNumberInputView;

public class LottoApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int paymentAmount = PaymentAmountInputView.getPaymentAmount(scanner);
        int lottoQuantity = LottoVendingMachine.calculate(paymentAmount);
        BuyResultResponseView.show(lottoQuantity);

        // create Lotter numbers
        LottoNumbers lottoNumbers = LottoVendingMachine.buy(lottoQuantity);

        GeneratedLottoResponseView.show(lottoNumbers.getLottoNumbers());

        WinningNumber winningNumber = WinningNumberInputView.getWinningNumber(scanner);

        MatchResultTitle.show();
        LottoMatchResults lottoMatchResults = new LottoMatchResults(lottoNumbers.guess(winningNumber));
        LottoResultAggregation lottoResultAggregation = new LottoResultAggregation(lottoMatchResults.rewardableAggregate());

        showLottoResultAggregation(lottoResultAggregation);
        showLottoYield(paymentAmount, lottoMatchResults.sumRewardAmount());
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
