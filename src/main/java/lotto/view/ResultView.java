package lotto.view;

import lotto.domain.LottoGameResults;
import lotto.domain.PrizeUnit;
import lotto.domain.WinResult;

import java.util.Arrays;
import java.util.Map;

public class ResultView {

    private static final String WINNING_RESULT_MESSAGE = "\n당첨 통계\n---------";

    public static void getLottoTickets(LottoGameResults lottoGameResults) {
        System.out.println(lottoGameResults.getLottoIssueResult().getTicketCount() +"개를 구매했습니다.");

        lottoGameResults.getLottoIssueResult().getLottoTickets()
                .stream().forEach(lottoTicket -> System.out.println(Arrays.toString(lottoTicket.getSortedLottoNumbers().toArray())));

    }

    public static void getPrizeResult(Map<WinResult, Integer> resultsMap) {
        System.out.println(WINNING_RESULT_MESSAGE);

        resultsMap.entrySet()
                .stream().forEach(set -> { PrizeUnit unit = PrizeUnit.findPrizeFieldByUnitCount(set.getKey().prizeUnit, set.getKey().isMatchBonusNumber);
                                System.out.println(set.getKey().prizeUnit+"개 일치"
                                        +(set.getKey().isMatchBonusNumber ? ", 보너스 볼 일치":" ")
                                        + "("+ unit.prizeUnitMoney+"원)- "+ set.getValue()+"개");}
                                );
    }

    public static void getProfitResult(double profit) {
        System.out.println("총 수익률은 "+profit+"입니다.(기준이 1이기 때문에 결과적으로 "+(profit > 1.0 ? "이득":"손해") +"라는 의미임)");
    }
}
