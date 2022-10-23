package lotto;

import lotto.dto.LottoResultAggregation;
import lotto.model.BonusNumber;
import lotto.model.LottoMatchResults;
import lotto.model.LottoNumbers;
import lotto.model.LottoReward;
import lotto.model.WinningNumber;
import lotto.view.input.BonusNumberInputView;
import lotto.view.input.ConsoleUserInterface;
import lotto.view.input.PaymentAmountInputView;
import lotto.view.input.UserInterface;
import lotto.view.input.WinningNumberInputView;
import lotto.view.response.BuyResultResponseView;
import lotto.view.response.GeneratedLottoResponseView;
import lotto.view.response.LottoResultAggregationResponseView;
import lotto.view.response.LottoYieldResponseView;
import lotto.view.response.MatchResultTitleResponseView;

public class LottoApplication {
    private static final UserInterface userInterface = new ConsoleUserInterface();

    public static void main(String[] args) {
        int paymentAmount = new PaymentAmountInputView(userInterface).getPaymentAmount();
        int lottoQuantity = LottoVendingMachine.calculate(paymentAmount);
        BuyResultResponseView.show(lottoQuantity);

        // create Lotter numbers
        LottoNumbers lottoNumbers = LottoVendingMachine.buy(lottoQuantity);

        GeneratedLottoResponseView.show(lottoNumbers.getLottoNumbers());

        WinningNumber winningNumber = new WinningNumberInputView(userInterface).getWinningNumber();
        BonusNumber bonusNumber = new BonusNumberInputView(userInterface).getBonusNumber();

        MatchResultTitleResponseView.show();
        LottoMatchResults lottoMatchResults = new LottoMatchResults(lottoNumbers.guess(winningNumber, bonusNumber));
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
        System.out.println(new LottoYieldResponseView().toMessage(new LottoYield(paymentAmount, rewardAmount)));
    }
}
