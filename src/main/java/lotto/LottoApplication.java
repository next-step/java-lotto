package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LottoApplication {

    public static void main(String[] args) {

        InputView input = new InputView();
        int paymentPrice = new LottoPayment(input.displayLottoIntro()).pay();
        Lotto lotto = new Lotto(paymentPrice);
        ResultView resultView = new ResultView();

        input.displayIntroInputUI(paymentPrice);
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        resultView.displayLottoNumbers(lottoNumbers);

        String[] inputNumber = input.displayLastLottoNumberInputUI();
        int bonusNumber = input.displayBonusLottoNumberInputUI();

        List<RewardStatus> lottoRankList = lotto.getRewardLotto(inputNumber, bonusNumber);
        RankReward rankReward = new RankReward(new LottoResult(lottoRankList).getLottoResult());
        resultView.displayResult(rankReward);
        resultView.displayResultRateMessage((float) rankReward.getTotalPrize() / paymentPrice);
    }

}
