package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNumber {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Prize, Integer> calcLottoRankWithBonus(Lotto lotto) {
        Map<Prize, Integer> rankMap = initRankMap();

        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            int matchingCount = findMatchingCount(lottoNumber);
            boolean containBonusNumber = lottoNumber.isContainBonusNumber(bonusNumber);
            addRankMap(rankMap, Prize.findPrize(matchingCount, containBonusNumber));
        }

        return rankMap;
    }

    private int findMatchingCount(LottoNumber lottoNumber) {
        return (int) numbers.stream().filter(n -> lottoNumber.getNumbers().contains(n)).count();
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
