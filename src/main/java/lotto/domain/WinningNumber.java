package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Map<Prize, Integer> calcLottoRank(Lotto lotto) {
        Map<Prize, Integer> rankMap = initRankMap();

        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            int matchingCount = lottoNumber.findMatchingCount(numbers);
            addRankMap(rankMap, Prize.findPrize(matchingCount));
        }
        return rankMap;
    }

    private Map<Prize, Integer> initRankMap() {
        Map<Prize, Integer> rankMap = new HashMap<>();
        for (Prize value : Prize.values()) {
            rankMap.put(value, 0);
        }
        return rankMap;
    }

    private void addRankMap(Map<Prize, Integer> rankMap, Prize prize) {
        rankMap.put(prize, rankMap.get(prize) + 1);
    }
}
