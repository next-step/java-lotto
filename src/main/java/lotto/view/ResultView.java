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

    public void showStatistic(List<Lotto> lottoBundle, int price) {
        Map<Integer, Integer> map = new HashMap<>();
        int input = price * lottoBundle.size();
        int totalPrice = 0;

        IntStream.range(3, 7).map(index -> map.put(index, 0));

        for(Lotto lotto : lottoBundle) {
            map.put(lotto.getMatchNumber(), map.getOrDefault(lotto.getMatchNumber(), 0)+1);
        }

//         map.putAll(result.stream()
//                           .filter(number -> number >= 3)
//                           .collect(Collectors.groupingBy(arg -> arg, new HashMap<Integer, Integer>(), Collectors.counting())));
//
//        Map<Integer, Integer> result =
//            lottoBundle.stream().collect(Collectors.groupingBy(item -> item.getMatchNumber(), Collectors.counting()));

        Iterator<Integer> keys = map.keySet().iterator();
        System.out.println(keys);

        while( keys.hasNext() ){
            int key = keys.next();
            int rewardPrice = RewardTable.rewardTableInfo(key).calculateReward(Math.toIntExact(map.get(key)));
            totalPrice += rewardPrice;
            System.out.println("!!!"+key);
            System.out.printf("%d개 일치 (%d원)- %d개", key, rewardPrice/map.get(key), map.get(key));
        }

        showRoi(totalPrice, input);
    }

    private void showRoi(int totalPrice, int input) {
        double result = (totalPrice - input) / input * 100;
        if(totalPrice == 0 || input == 0){
            result = 0;
        }
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", result);
    }
}
