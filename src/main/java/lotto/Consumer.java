package lotto;

import common.model.Number;
import common.view.InputView;
import common.view.OutputView;
import lotto.application.Constant;
import lotto.factory.LottoNumberFactory;
import lotto.factory.LottoNumbersFactory;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoStore;
import lotto.model.LottoWinner;

import java.util.Map;

public class Consumer {

    public static void main(String[] args) {
        int purchaseAmount = InputView.nextInt(Constant.INPUT_MESSAGE_PURCHASE_AMOUNT);

        Lotto lotto = LottoStore.ticket(purchaseAmount);
        OutputView.print(lotto);

        String winnerNumbers = InputView.nextLine(Constant.INPUT_MESSAGE_WINNER_NUMBERS);
        int bonusNumber = InputView.nextInt(Constant.INPUT_MESSAGE_BONUS_NUMBER);

        LottoWinner lottoWinner = new LottoWinner(LottoNumbersFactory.manualCreateNumberList(winnerNumbers), LottoNumberFactory.manualCreateNumber(bonusNumber));

        Map<LottoRank, Number> result = lotto.matchAll(lottoWinner);

        OutputView.print(result, purchaseAmount);
    }

}
