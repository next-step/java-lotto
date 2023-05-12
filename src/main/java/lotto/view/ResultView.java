package lotto.view;

import lotto.domain.LottoTicket;
import lotto.util.RewardTable;

import java.util.*;

public class ResultView {

    private static String RESULT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static String RESULT_GAME = "당첨 통계";
    private static String BREAK_LINE = "------";

    public ResultView() {}

    public void showBuyLotto(int noAutoCount, int autoCount) {
        System.out.printf(RESULT_MESSAGE, noAutoCount, autoCount);
    }

    public void showMyLottoGameList(List<LottoTicket> lottoTickets) {

        for(LottoTicket lotto : lottoTickets) {
            System.out.println(lotto.getLottoNumbers().toString());
        }
    }

    public void resultGame(Map<RewardTable, Long> map, double rate) {
        System.out.println(RESULT_GAME);
        System.out.println(BREAK_LINE);

        map.remove(RewardTable.MISS);

        List<RewardTable> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (RewardTable key : keySet) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", key.getMatchCount(), key.getReward(), map.get(key));
        }

        resultRateOfReturn(rate);
    }

    private void resultRateOfReturn(double rate){
        String benefitWord = "손해";

        if (rate > 0) {
            benefitWord = "이득이";
        }

        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", rate, benefitWord);
    }
}
