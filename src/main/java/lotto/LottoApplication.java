package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LottoApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InputView input = new InputView();
        int paymentPrice = new LottoPayment(sc.nextLine()).pay();
        Lotto lotto = new Lotto(paymentPrice);
        ResultView resultView = new ResultView();

        input.displayIntroInputUI(paymentPrice);
        List<List<Integer>> lottoNumbers = lotto.getLottoNumbers();
        resultView.displayLottoNumbers(lottoNumbers);

        input.displayLastLottoNumberInputUI();
        String[] inputNumber = sc.nextLine().split(input.DELIMITER);
        input.displayBonusLottoNumberInputUI();
        int bonusNumber = sc.nextInt();

        List<RewardLotto> lottoRankList = lotto.getRewardLotto(inputNumber, bonusNumber);
        resultView.displayResult(new LottoResult(lottoRankList).getLottoResult(), paymentPrice);
    }

}
