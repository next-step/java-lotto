package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Store;
import lotto.utility.RewardTable;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public void showMyLotto(List<Lotto> lottoBundle) {
        System.out.println(lottoBundle.size() + "개를 구매하셨습니다.");

        for(Lotto lotto : lottoBundle) {
            System.out.println(lotto.getCheckedNumbers());
        }
    }
    private int printPrice(int key, int value) {
        int totalReward = 0;

        if(key >= RewardTable.MINIMUN_MATCH_NUMBER) {
            totalReward = RewardTable.rewardTableInfo(key).calculateReward(value);
            int reward = RewardTable.rewardTableInfo(key).amountOfReward();
            System.out.printf("%d개 일치 (%d원)- %d개\n", key, reward, value);
        }

        return totalReward;
    }


    public void showStatistic(Map<Integer, Integer> map, int lottoPrice) {
        System.out.println("당첨 통계\n---------");

        int totalPrice = 0;
        int numberOfLotto = 0;

        Iterator<Integer> keys = map.keySet().iterator();

        while( keys.hasNext() ){
            int key = keys.next();
            int value = map.get(key);

            numberOfLotto += value;
            totalPrice += printPrice(key, value);
        }

        showRoi(totalPrice, lottoPrice * numberOfLotto);
    }

    private void showRoi(int totalPrice, int input) {
        double result = 1 + (totalPrice - input) / (double)input;
        String benefit = "손해";

        if(result>0) {
            benefit = "이득이";
        }

        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", result, benefit);
    }
}
