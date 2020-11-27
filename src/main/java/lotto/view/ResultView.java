package lotto.view;

import lotto.domain.LottoGameResults;
import lotto.domain.LottoNumber;
import lotto.domain.PrizeUnit;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String WINNING_RESULT_MESSAGE = "\n당첨 통계\n---------";

    public static void getLottoTickets(LottoGameResults lottoGameResults) {

        int totalTicketCount = lottoGameResults.getLottoIssueResult().getTicketCount();
        int manualTicketCount = lottoGameResults.getLottoIssueResult().getManualTicket().size();

        System.out.println("\n수동으로 "+manualTicketCount+"장, 자동으로 "+(totalTicketCount-manualTicketCount)+"개를 구매했습니다.");

        lottoGameResults.getLottoIssueResult().getLottoTickets()
                .stream().forEach(lottoTicket -> System.out.println(Arrays.toString(makeArray(lottoTicket.getSortedLottoNumbers()))));

    }

    private static int[] makeArray(List<LottoNumber> sortedLottoNumbers) {
        return sortedLottoNumbers.stream().mapToInt(LottoNumber::getNumber).toArray();
    }


    public static void getPrizeResult(Map<PrizeUnit, Integer> resultsMap) {
        System.out.println(WINNING_RESULT_MESSAGE);

        resultsMap.entrySet()
                .stream().filter(prizeUnitSet -> prizeUnitSet.getKey() != PrizeUnit.FAIL_GRADE)
                    .forEach(prizeUnitSet -> { System.out.println(prizeUnitSet.getKey().prizeUnitCount+"개 일치"
                    +(prizeUnitSet.getKey() == PrizeUnit.SECOND_GRADE ? ", 보너스 볼 일치":" ")
                    + "("+ prizeUnitSet.getKey().prizeUnitMoney+"원)- "+ prizeUnitSet.getValue()+"개");}
        );
    }

    public static void getProfitResult(double profit) {
        System.out.println("총 수익률은 "+profit+"입니다.(기준이 1이기 때문에 결과적으로 "+(profit > 1.0 ? "이득":"손해") +"라는 의미임)");
    }
}
