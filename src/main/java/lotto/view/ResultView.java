package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.enums.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.domain.enums.LottoRank.MISS;

public class ResultView {

    public void printLotto(int manualCnt, int autoCnt, List<LottoTicket> lottoTickets)
    {
        System.out.println("\n수동으로 "+ manualCnt+"장, 자동으로 "+ autoCnt+"장을 구매했습니다.");
        lottoTickets.stream().forEach(System.out::println);
        System.out.println();
    }

    public void printResult(Map<LottoRank, Integer> result, double totalRate){

        String str ="";
        System.out.println("\n당첨 통계\n---------");

        List<LottoRank> keyList = new ArrayList<>(result.keySet());
        Collections.sort(keyList, Collections.reverseOrder());
        for (LottoRank key : keyList) {
            if(key != MISS)
                System.out.println( String.format("%s - %s개", key, result.get(key)) );
        }

        if(totalRate < 1)
            str = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

        System.out.println( String.format("총 수익률은 %.2f입니다.%s", totalRate, str));
    }

}