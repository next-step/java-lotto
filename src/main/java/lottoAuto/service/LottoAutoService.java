package lottoAuto.service;

import java.util.*;

public class LottoAutoService {

    private List<Integer> winning_count;
    private List<Integer> bonus_count;

    public List<Integer> statistic(List<List> result, List<Integer> winningNum) {

        winning_count = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            int count = 0;
            for (int j = 0; j < winningNum.size(); j++) {
                if (result.get(i).contains(winningNum.get(j))) {
                    count++;

                }
            }
            winning_count.add(count);
        }
        return winning_count;
    }

    public List<Integer> statisticBonus(List<List> result, int bonus) {
        bonus_count = new ArrayList<>();


        for (int i = 0; i < result.size(); i++) {
            int count = 0;
            if (winning_count.get(i) == 5 && result.get(i).contains(bonus)) {
                count = 5;
                bonus_count.add(count);
            }else {
                bonus_count.add(count);
            }

        }

        return bonus_count;
    }

    public double revenue(WinningCount winningCount) {
//        int revenueNum = (5000* winningCount.three + 50000* winningCount.four + 1500000* winningCount.five + 30000000* winningCount.fiveBonus+2000000000* winningCount.six)/price;
        return 0.0;
    }
}
