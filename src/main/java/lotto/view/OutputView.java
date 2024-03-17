package lotto.view;

import lotto.LottoConstants;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;

import java.util.List;

import static lotto.LottoConstants.*;

public class OutputView {

    public void printLottoNumbers(LottoNumbers lottoNumbers) {
        List<String> lottoNumbersToString = lottoNumbers.getLottoNumbersToString();
        for (String lottoNumberString : lottoNumbersToString) {
            System.out.println(lottoNumberString);
        }
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (" + THREE_NUMBER_CORRECT_WINNINGS + ") - " + lottoResult.getCountOfThreeCorrectLotto() + "개");
        System.out.println("4개 일치 (" + FOUR_NUMBER_CORRECT_WINNINGS + ") - " + lottoResult.getCountOfFourCorrectLotto() + "개");
        System.out.println("5개 일치 (" + FIVE_NUMBER_CORRECT_WINNINGS + ") - " + lottoResult.getCountOfFiveCorrectLotto() + "개");
        System.out.println("6개 일치 (" + SIX_NUMBER_CORRECT_WINNINGS + ") - " + lottoResult.getCountOfSixCorrectLotto() + "개");
        System.out.println("총 수익률은 " + lottoResult.rateOfReturn() + "입니다.");
    }
}
