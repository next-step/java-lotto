package lotto.view;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.MatchType;

public class ResultView {

    private static final int LOTTO_PRICE = 1000;

    public ResultView() {
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> printLottoNumber(lotto));
        System.out.println();
    }

    public static void printLottoGameResult(LottoResult lottoResult) {
        System.out.println("당첨 통계\n---------");
        Map<MatchType, Integer> matchResult = lottoResult.getMatchResult();
        for (Map.Entry<MatchType, Integer> entry : matchResult.entrySet()) {
            printMatchNumber(entry);
        }
        printTotalYield(lottoResult.getYield());
    }

    private static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getLottoNumber());
    }

    private static void printMatchNumber(Map.Entry<MatchType, Integer> entry) {
        System.out.println(
            entry.getKey().getCount() + "개 일치(" +
                entry.getKey().getMoney() + ")-" +
                entry.getValue() + "개");
    }

    private static void printTotalYield(float yield) {
        System.out.println("총 수익률은 " + yield + "입니다.");
    }

}
