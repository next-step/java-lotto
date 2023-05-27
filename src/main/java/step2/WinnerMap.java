package step2;

import java.util.HashMap;
import java.util.Map;

import static step2.LottoMatch.*;

public class WinnerMap {

    private static Map<String, Integer> winnerMap = new HashMap<>();

    static void winnerMapInit() {
        winnerMap.put(FIFTH.name(), 0);
        winnerMap.put(FOURTH.name(), 0);
        winnerMap.put(THIRD.name(), 0);
        winnerMap.put(SECOND.name(), 0);
        winnerMap.put(FIRST.name(), 0);
    }

    public static void plusWinnerMapCount(LottoMatch lottoMatch, int matchCount) {
        winnerMap.put(lottoMatch.name(), winnerMap.get(lottoMatch.name())+1);
    }

    public static Map<String, Integer> getWinnerMap() {
        return winnerMap;
    }
}
