package lotto.domain;

import lotto.utility.RewardTable;

import java.util.*;

public class WinningStatistics {
    public final List<Integer> targetNumber;

    public WinningStatistics(List<Integer> targetNumber) {
        this.targetNumber = targetNumber;
    }

    private Map<Integer, Integer> makeResultMap() {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<=6; i++) {
            map.put(i, 0);
        }

        return map;
    }

    public Map<Integer, Integer> lottoResult(List<Lotto> lottoBundle) {
        Map<Integer, Integer> map = makeResultMap();

        for(Lotto lotto : lottoBundle) {
            map.put(lotto.matchLottoNumber(this.targetNumber), map.getOrDefault(lotto.matchLottoNumber(this.targetNumber), 0) + 1);
        }

        // 작동이 안되는 이유가 무엇인가요?
        // 위와 뭐가 다른 지 모르겠습니다...
//        lottoBundle.stream()
//                .mapToInt(lotto -> lotto.matchLottoNumber(this.targetNumber))
//                .map(key -> map.put(key, map.getOrDefault(key, 0) + 1));

        return map;
    }

    private int calcWinningPrice(int key, int value) {
        if(key >= RewardTable.MINIMUM_MATCH_NUMBER) {

            return RewardTable.rewardTableInfo(key).calculateReward(value);
        }

        return 0;
    }

    public double calcRoi(int totalWinningPrice, int investment) {
        double result = 1 + (totalWinningPrice - investment) / (double)investment;

        return result;
    }

    public int sumTotalWinningPrice(Map<Integer, Integer> map) {
        int totalWinningPrice = 0;

        Iterator<Integer> keys = map.keySet().iterator();

        while( keys.hasNext() ){
            int key = keys.next();
            int value = map.get(key);

            totalWinningPrice += calcWinningPrice(key, value);
        }

        return totalWinningPrice;
    }

    public List<Integer> showTargetNumber() {
        return new ArrayList<>(this.targetNumber);
    }
}
