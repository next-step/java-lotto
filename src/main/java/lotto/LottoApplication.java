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
        List<Integer> lottoRankList = lotto.getLottoWinnerNumbers(sc.nextLine().split(input.DELIMITER));

        resultView.displayResult(new WinningNumbers(new LottoResult(lottoRankList).getLottoResult()), paymentPrice);
    }

}
