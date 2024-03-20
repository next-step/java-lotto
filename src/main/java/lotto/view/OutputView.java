package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;

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
        System.out.println("3개 일치 (" + LottoRank.THREE_NUMBER_CORRECT.getWinnings() + "원) - " + lottoResult.getCorrectCountsByLottoRank(LottoRank.THREE_NUMBER_CORRECT) + "개");
        System.out.println("4개 일치 (" + LottoRank.FOUR_NUMBER_CORRECT.getWinnings() + "원) - " + lottoResult.getCorrectCountsByLottoRank(LottoRank.FOUR_NUMBER_CORRECT) + "개");
        System.out.println("5개 일치 (" + LottoRank.FIVE_NUMBER_CORRECT.getWinnings() + "원) - " + lottoResult.getCorrectCountsByLottoRank(LottoRank.FIVE_NUMBER_CORRECT) + "개");
        System.out.println("6개 일치 (" + LottoRank.SIX_NUMBER_CORRECT.getWinnings() + "원) - " + lottoResult.getCorrectCountsByLottoRank(LottoRank.SIX_NUMBER_CORRECT) + "개");
        System.out.println("총 수익률은 " + lottoResult.rateOfReturn() + "입니다.");
    }
}
