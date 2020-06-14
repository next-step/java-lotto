package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {

        InputView input = new InputView();
        int lottoCount = new LottoPayment(input.displayLottoIntro()).pay();
        List<String> manualNumber = input.displayManualLottoNumberInputUI();
        Lotto lotto = new Lotto(lottoCount - manualNumber.size(), manualNumber);
        ResultView resultView = new ResultView();

        input.displayIntroInputUI(lottoCount);
        resultView.displayLottoNumbers(lotto.getManualLottoNumbers(), lotto.getAutoLottoNumbers());

        String[] inputNumber = input.displayLastLottoNumberInputUI();
        int bonusNumber = input.displayBonusLottoNumberInputUI();

        List<RewardStatus> lottoRewars = lotto.getManualRewardLotto(inputNumber, bonusNumber);
        lottoRewars.addAll(lotto.getAutoRewardLotto(inputNumber, bonusNumber));

        LottoResult lottoResult = new LottoResult(lottoRewars);
        resultView.displayResult(lottoResult);
        resultView.displayResultRateMessage(lottoResult.getLottoProfit(lottoCount));
    }

}
