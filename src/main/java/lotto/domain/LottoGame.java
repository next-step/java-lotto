package lotto.domain;


import lotto.constants.Const;
import lotto.enums.RewardEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private Lottos lottos;
    private Map<Integer, Integer> countMap;

    public LottoGame(int tryNo) {
        // 로또 장수만큼 6자리 숫자를 랜덤 뽑기한다.
        this.lottos = new Lottos(tryNo);
        this.countMap = new HashMap<>();
        countMap.put(3, 0);
        countMap.put(4, 0);
        countMap.put(5, 0);
        countMap.put(6, 0);
    }

    public LottoGame(Lottos lottos) {
        this.lottos = lottos;
        this.countMap = new HashMap<>();
    }

    public Lottos run(int tryNo) {
        // 로또 장수만큼 6자리 숫자를 랜덤 뽑기한다.
        lottos = new Lottos(tryNo);
        return lottos;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public double profitRate() {
        // 수익률을 계산한다.
        int totalReward = countMap.entrySet().stream()
                .filter(entry -> RewardEnum.fromMatchingCount(entry.getKey()) != null)
                .mapToInt(entry -> RewardEnum.fromMatchingCount(entry.getKey()).getReward() * entry.getValue())
                .sum();

        return (double) totalReward / (lottos.of().size() * Const.LOTTO_COST);
    }

    public Map<Integer, Integer> countLottosByMatchingCount(List<Integer> winningNo) {
        // 당첨번호와 일치 여부를 비교해서 일치 갯수를 판별한다.
        for (Lotto lotto : lottos.of()) {
            int matchingCount = lotto.getMatchingCount(winningNo);
            countMap.put(matchingCount, countMap.getOrDefault(matchingCount, 0) + 1);
        }
        return countMap;
    }
}
