package lotto.ui;

import lotto.domain.WinningToLotto;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultView {
    static final String WINNER_STATISTICS = "당첨 통계";

    static final String RESULT_WINNER = "%d개 일치 (%d원)- %d개\n";

    static final String TOTAL_AMOUNT = "총 수익률은 %.2f입니다.";

    static final int LOTTO_PRICE = 1000;

    public static void buyLottoList(List<List<Integer>> buyLottoList){
        for(List<Integer> list : buyLottoList){
            System.out.println(list);
        }
    }

    public static void resultView(Map<Integer, Integer> resultMap, int lottoCount){

        int sumAmount = 0;

        Set<Integer> keys = resultMap.keySet();
        for (Integer key : keys) {
            Integer value = resultMap.get(key);
            System.out.printf(RESULT_WINNER, key, WinningToLotto.getWinningAmount(key), value);
            sumAmount += value*WinningToLotto.getWinningAmount(key);
        }

        System.out.printf(TOTAL_AMOUNT, (double)sumAmount/(lottoCount*LOTTO_PRICE));
    }
}
