package lotto.view;

import lotto.domain.LottoGameResults;
import lotto.domain.PrizeUnit;

import java.util.Arrays;
import java.util.Map;

public class ResultView {

    public static void getLottoTickets(LottoGameResults lottoGameResults) {
        System.out.println(lottoGameResults.getLottoGameResults().size() +"개를 구매했습니다.");
        lottoGameResults.getLottoGameResults()
                .stream().forEach(lottoGameResult -> System.out.println(Arrays.toString(lottoGameResult.getLottoGameResult().toArray())));
    }

    public static void getPrizeResult(Map<Integer, Integer> resultsMap) {
        System.out.println("\n당첨 통계\n---------");

        resultsMap.entrySet()
                .stream().forEach(set -> { PrizeUnit unit = PrizeUnit.findPrizeFieldByUnitCount(set.getKey());
                                System.out.println(set.getKey()+"개 일치 ("+ unit.prizeUnitMoney+"원)- "+ set.getValue()+"개");}
                                );
    }

    public static void getProfitResult(double profit) {
        System.out.println("총 수익률은 "+profit+"입니다.(기준이 1이기 때문에 결과적으로 "+(profit > 1.0 ? "이득":"손해") +"라는 의미임)");
    }
}
