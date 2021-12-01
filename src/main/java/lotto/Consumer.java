package lotto;

import common.view.InputView;
import common.view.OutputView;
import lotto.application.Constant;
import lotto.factory.LottoNumberFactory;
import lotto.factory.LottoNumbersFactory;
import lotto.model.*;

import java.util.ArrayList;
import java.util.List;

public class Consumer {

    public static void main(String[] args) {
        int purchaseAmount = InputView.nextInt(Constant.INPUT_MESSAGE_PURCHASE_AMOUNT);
        int manualLottoCount = InputView.nextInt(Constant.INPUT_MESSAGE_MANUAL_LOTTO_COUNT);
        OutputView.print(Constant.INPUT_MESSAGE_MANUAL_LOTTO_NUMBER);

        List<LottoNumbers> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String manualLottoNumbersInput = InputView.nextLine();
            manualLottoNumbers.add(LottoNumbersFactory.createByInput(manualLottoNumbersInput));
        }
        Lotto lotto = LottoStore.ticket(purchaseAmount, manualLottoNumbers);
        OutputView.print(lotto, manualLottoCount);

        String winnerNumbers = InputView.nextLine(Constant.INPUT_MESSAGE_WINNER_NUMBERS);
        int bonusNumber = InputView.nextInt(Constant.INPUT_MESSAGE_BONUS_NUMBER);

        LottoWinner lottoWinner = LottoNumbersFactory.createWinner(winnerNumbers, LottoNumberFactory.createByNumber(bonusNumber));

        LottoReport report = lotto.matchAll(lottoWinner);
        OutputView.print(report, purchaseAmount);
    }

}
