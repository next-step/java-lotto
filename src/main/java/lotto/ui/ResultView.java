package lotto.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.result.LottoGameResult;
import lotto.domain.result.MatchResult;

public class ResultView {

    public static void printLottoGameResult(LottoGameResult lottoGameResult) {
        List<MatchResult> matchResults = lottoGameResult.getLottoMatchResults().getMatchResults();
        double yield = lottoGameResult.getYield();
        StringBuilder stringBuilder = new StringBuilder();

        String result = "당첨 통계\n---------\n";

        result += "3개 일치 (5000원)- " + matchResults.get(1).getMatchedLottoNumberCount() + "개\n";
        result += "4개 일치 (50000원)- " + matchResults.get(2).getMatchedLottoNumberCount() + "개\n";
        result += "5개 일치 (1500000원)- " + matchResults.get(3).getMatchedLottoNumberCount() + "개\n";
        result += "5개 일치, 보너스 볼 일치(30000000원) - " + matchResults.get(4).getMatchedLottoNumberCount() + "개\n";
        result += "6개 일치 (2000000000원)- " + matchResults.get(5).getMatchedLottoNumberCount() + "개\n";

        result += "총 수익률은 " + yield + "입니다";

        stringBuilder.append("총 수익률은 ").append(yield).append("입니다.");

        if (yield < 1) {
            result += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        System.out.println(result);
    }

    public static void printLottos(Lottos lottos, int manualLottoCount) {
        List<Lotto> lottoList = lottos.getLottoList();
        String result = "";

        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + (lottoList.size() - manualLottoCount) + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            result += "[";
            List<LottoNumber> lottoNumbers = new ArrayList<>(lotto.getLottoNumbers());
            Collections.sort(lottoNumbers);
            for (LottoNumber lottoNumber : lottoNumbers) {
                result += lottoNumber.getNumber() + ", ";
            }

            result = result.substring(0, result.length() - 2) + "]\n";
        }

        System.out.println(result);
    }
}
