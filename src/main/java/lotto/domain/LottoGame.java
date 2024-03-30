package lotto.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private Lottos lottos;
    private final Map<Integer, Integer> countMap;
    public static final int LOTTO_COST = 1000;

    public LottoGame(int tryNo) {
        // 로또 장수만큼 6자리 숫자를 랜덤 뽑기한다.
        this.lottos = new Lottos(tryNo);
        this.countMap = new HashMap<>();
        countMap.put(Reward.THREE.getMatchingCount(), 0);
        countMap.put(Reward.FOUR.getMatchingCount(), 0);
        countMap.put(Reward.FIVE.getMatchingCount(), 0);
        countMap.put(Reward.SIX.getMatchingCount(), 0);
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
                .filter(entry -> Reward.fromMatchingCount(entry.getKey()) != null)
                .mapToInt(entry -> Reward.fromMatchingCount(entry.getKey()).getReward() * entry.getValue())
                .sum();

        return (double) totalReward / (lottos.of().size() * LOTTO_COST);
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
