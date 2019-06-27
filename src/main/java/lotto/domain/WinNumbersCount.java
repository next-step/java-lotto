package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class WinNumbersCount {
    private final static int DEFAULT_WIN_COUNT = 0;
    private Map<Prize, Integer> winNumbersCount;
    
    public WinNumbersCount() {
        winNumbersCount = new LinkedHashMap<>();
        Arrays.stream(Prize.values()).forEach(prize -> winNumbersCount.put(prize, DEFAULT_WIN_COUNT));
    }
    
    public int addWinCount(final int matchCount, final boolean isMatchedBonus) {
        final Prize matchPrize = Prize.getPrize(matchCount, isMatchedBonus);
        if (matchPrize == null) {
            return DEFAULT_WIN_COUNT;
        }
        
        int nowCount = winNumbersCount.get(matchPrize);
        winNumbersCount.put(matchPrize, ++nowCount);
        return nowCount;
    }
    
    public int addWinCount(final int matchCount) {
        return this.addWinCount(matchCount, false);
    }
    
    public long getTotalPrizeMoney() {
        return winNumbersCount.keySet().stream()
          .mapToLong(prize -> winNumbersCount.get(prize) * prize.getPrizeMoney())
          .reduce(Long::sum)
          .orElseThrow(RuntimeException::new);
    }
    
    public Set<Prize> getPrizes() {
        return winNumbersCount.keySet();
    }
    
    public int getMatchedCountAt(Prize prize) {
        return winNumbersCount.get(prize);
    }
}
