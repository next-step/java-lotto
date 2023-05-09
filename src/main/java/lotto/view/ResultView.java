package lotto.view;

import lotto.domain.LottoGame;
import lotto.util.RewardTable;

import java.util.*;

public class ResultView {

    private static String RESULT_MESSAGE = "개를 구매했습니다.";
    private static String RESULT_GAME = "당첨 통계";
    private static String BREAK_LINE = "------";

    public ResultView() {}

    public void showBuyLotto(int gameCount) {
        System.out.println(gameCount + RESULT_MESSAGE);
    }

    public void showMyLottoGameList(List<LottoGame> lottoGames) {

        for(LottoGame lotto : lottoGames) {
            System.out.println(lotto.getLottoNumber().toString());
        }
    }

    public void resultGame(Map<RewardTable, Integer> map, double rate) {
        System.out.println(RESULT_GAME);
        System.out.println(BREAK_LINE);

        List<RewardTable> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (RewardTable key : keySet) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", key.getMatchRank(), key.getReward(), map.get(key));
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
