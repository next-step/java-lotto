package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinNumbersCount {
    private final static int DEFAULT_WIN_COUNT = 0;
    private Map<Prize, Integer> winNumbersCount;
    
    public WinNumbersCount() {
        winNumbersCount = new LinkedHashMap<>();
        Arrays.stream(Prize.values()).forEach(prize -> winNumbersCount.put(prize, DEFAULT_WIN_COUNT));
    }
    
    public int addWinCount(int matchCount) {
        Prize matchPrize = Prize.getPrize(matchCount);
        int nowCount = winNumbersCount.get(matchPrize);
        winNumbersCount.put(matchPrize, nowCount++);
        return nowCount;
    }
}
