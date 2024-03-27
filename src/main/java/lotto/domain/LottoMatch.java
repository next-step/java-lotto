package lotto.domain;

import lotto.constant.Constant;

import java.util.HashMap;
import java.util.List;

public class LottoMatch {
    private static final int MATCH_COUNT_STANDARD = 3;

    public static HashMap<Integer, Integer> setMatchResult() {
        return new HashMap<>() {{
            put(Rank.valueOf(Constant.THREE_AGREEMENT).getPrize(), 0);
            put(Rank.valueOf(Constant.FOUR_AGREEMENT).getPrize(), 0);
            put(Rank.valueOf(Constant.FIVE_AGREEMENT).getPrize(), 0);
            put(Rank.valueOf(Constant.SIX_AGREEMENT).getPrize(), 0);
        }};
    }

    public static HashMap<Integer, Integer> match(Lottos lottos, List<Integer> winNumbers) throws IllegalArgumentException{
        List<Lotto> lottoList = lottos.getLottos();
        HashMap<Integer, Integer> matchResult = setMatchResult();
        int matchCount;

        for (Lotto lotto : lottoList) {
            matchCount = LottoMatchCount.matchCount(lotto.getLotto(), winNumbers);
            putMatchResult(matchCount, matchResult);
        }

        return matchResult;
    }

    private static void putMatchResult(int matchCount, HashMap<Integer, Integer> matchResult) {
        if (matchCount < MATCH_COUNT_STANDARD) {
            return;
        }

        int prize = Rank.valueOf(matchCount).getPrize();
        matchResult.put(prize, matchResult.getOrDefault(prize, 0) + 1);
    }
}
