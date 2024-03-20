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
        System.out.println("3개 일치 (" + LottoRank.FIFTH.getWinnings() + "원) - " + lottoResult.getCorrectCountsByLottoRank(LottoRank.FIFTH) + "개");
        System.out.println("4개 일치 (" + LottoRank.FOURTH.getWinnings() + "원) - " + lottoResult.getCorrectCountsByLottoRank(LottoRank.FOURTH) + "개");
        System.out.println("5개 일치 (" + LottoRank.THIRD.getWinnings() + "원) - " + lottoResult.getCorrectCountsByLottoRank(LottoRank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + LottoRank.SECOND.getWinnings() + "원) - " + lottoResult.getCorrectCountsByLottoRank(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 (" + LottoRank.FIRST.getWinnings() + "원) - " + lottoResult.getCorrectCountsByLottoRank(LottoRank.FIRST) + "개");
        System.out.println("총 수익률은 " + lottoResult.rateOfReturn() + "입니다.");
    }
}
