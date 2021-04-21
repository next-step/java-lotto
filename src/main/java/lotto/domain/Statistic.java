package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {

    // 상금
    public static final int[] WINNINGPRICE = {0,0,0,5000,50000,1500000,2000000000};
    private static final int PRICE_START_NUM = 3;
    private static final int PRICE_MAX_NUM = 6;


    public static Map<Long, Integer> countLottoPerCorrectNum(List<Long> countLottoForEachCorrectNum){
        Map<Long,Integer> statistic = new HashMap<>();

        countLottoForEachCorrectNum.stream()
                .filter( correctNum -> correctNum >= PRICE_START_NUM )
                .forEach(correctNum -> {
                    statistic.put(correctNum,statistic.getOrDefault(correctNum, 0) + 1);
                });

        return statistic;
    }

    public static double getRevenueRate(int purchaseAmount, Map<Long,Integer> countLottoPerCorrectNum){
        float revenue = 0;
        for(int correctNum = PRICE_START_NUM; correctNum<=PRICE_MAX_NUM ; correctNum++){
            int count = countLottoPerCorrectNum.getOrDefault(Long.valueOf(correctNum),0);
            revenue += (count*WINNINGPRICE[correctNum]);
        }
        double revenueRate = Math.round((revenue / purchaseAmount) * 100) / 100.0;
        return revenueRate;
    }


}
