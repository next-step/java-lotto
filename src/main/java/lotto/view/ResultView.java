package lotto.view;

import lotto.constant.LottoRanking;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.Map;

public class ResultView {
    public void printLottoCount(LottoCount lottoCount) {
        System.out.println(lottoCount.getCount() + "개를 구매했습니다.");
    }

    public void printAllLottoNumbers(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getLottoNumbers());
        }
        System.out.println();
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------------");

        for (Map.Entry<LottoRanking, Integer> entry : lottoResult.getLottoRankings().entrySet()) {
            LottoRanking key = entry.getKey();
            if (key != LottoRanking.MISS) {
                System.out.println(key.getRanking() + "개 일치 (" + key.getAward() + "원) - " + entry.getValue() + "개");
            }
        }

        System.out.printf("총 수익률은 %2.02f 입니다.", lottoResult.getPercentage());
    }
}
