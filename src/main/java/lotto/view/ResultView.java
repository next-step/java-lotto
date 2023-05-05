package lotto.view;

import lotto.domain.Lotto;
import lotto.utility.RewardTable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ResultView {
    public void showMyLotto(List<Lotto> lottoBundle) {
        System.out.println(lottoBundle.size() + "개를 구매하셨습니다.");

        for(Lotto lotto : lottoBundle) {
            System.out.println(lotto.getCheckedNumbers());
        }
    }
    private int calcWinningPrice(int key, int value) {
        int totalReward = 0;

        if(key >= RewardTable.MINIMUM_MATCH_NUMBER) {
            totalReward = RewardTable.rewardTableInfo(key).calculateReward(value);
            System.out.printf("%d개 일치 (%d원)- %d개\n", key, RewardTable.rewardTableInfo(key).amountOfReward(), value);
        }

        return totalReward;
    }


    public void showStatistic(Map<Integer, Integer> map, int investment) {
        System.out.println("당첨 통계\n---------");

        int totalWinningPrice = 0;

        Iterator<Integer> keys = map.keySet().iterator();

        while( keys.hasNext() ){
            int key = keys.next();
            int value = map.get(key);

            totalWinningPrice += calcWinningPrice(key, value);
        }

        showRoi(totalWinningPrice, investment);
    }

    private void showRoi(int totalWinningPrice, int investment) {
        double result = 1 + (totalWinningPrice - investment) / (double)investment;
        String benefit = "손해";

        if(result>0) {
            benefit = "이득이";
        }

        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", result, benefit);
    }
}
