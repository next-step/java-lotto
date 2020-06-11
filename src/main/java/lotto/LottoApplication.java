package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LottoApplication {

    public static void main(String[] args) {

        InputView input = new InputView();
        int lottoCount = new LottoPayment(input.displayLottoIntro()).pay();
        Lotto lotto = new Lotto(lottoCount);
        ResultView resultView = new ResultView();

        input.displayIntroInputUI(lottoCount);
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        resultView.displayLottoNumbers(lottoNumbers);

        String[] inputNumber = input.displayLastLottoNumberInputUI();
        int bonusNumber = input.displayBonusLottoNumberInputUI();

        List<RewardStatus> lottoRewars = lotto.getRewardLotto(inputNumber, bonusNumber);
        LottoResult lottoResult = new LottoResult(lottoRewars);
        resultView.displayResult(lottoResult);
        resultView.displayResultRateMessage((float) lottoResult.getTotalPrize() / lottoCount);
    }

}
