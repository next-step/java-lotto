package lotto.domain.prize;

import lotto.domain.LottoNumber;
import lotto.domain.code.LottoMatchPrize;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoMatch {

    private final Map<LottoMatchPrize, Integer> matchMap;

    public LottoMatch(List<LottoNumber> pickNumbers, LottoNumber winningNumber) {
        matchMap = initializeMap(new EnumMap<>(LottoMatchPrize.class));
        addMatch(pickNumbers, winningNumber);
    }

    public int calculateEarnMoney() {
        int earn = 0;
        for (Map.Entry<LottoMatchPrize, Integer> entry : matchMap.entrySet()) {
            earn += calculateEarnMoney(entry.getKey(), entry.getValue());
        }
        return earn;
    }

    public Set<LottoMatchPrize> getMatches() {
        return matchMap.keySet();
    }

    public Integer getMatchCount(LottoMatchPrize match) {
        return matchMap.get(match);
    }

    private Map<LottoMatchPrize, Integer> initializeMap(Map<LottoMatchPrize, Integer> matchMap) {
        for (LottoMatchPrize lottoMatchPrize : LottoMatchPrize.values()) {
            matchMap.put(lottoMatchPrize, 0);
        }
        return matchMap;
    }

    private void addMatch(List<LottoNumber> pickNumbers, LottoNumber winningNumber) {
        for (LottoNumber pickNumber : pickNumbers) {
            add(pickNumber.matchCount(winningNumber));
        }
    }

    private void add(int matchCount) {
        LottoMatchPrize lottoMatchPrize = LottoMatchPrize.getBy(matchCount);
        matchMap.computeIfPresent(lottoMatchPrize, (k, v) -> v + 1);
    }

    private int calculateEarnMoney(LottoMatchPrize prize, int matchCount) {
        return prize.getMoney() * matchCount;
    }
}
