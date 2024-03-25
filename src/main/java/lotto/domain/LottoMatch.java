package lotto.domain;

import lotto.constant.Constant;

import java.util.HashMap;
import java.util.List;

public class LottoMatch {
    private static final int MATCH_COUNT_STANDARD = 3;
    private static HashMap<Integer, Integer> setUp(){
        return new HashMap<>(){{
            put(Constant.FIRST_PLACE, 0);
            put(Constant.SECOND_PLACE, 0);
            put(Constant.THIRD_PLACE, 0);
            put(Constant.FOURTH_PLACE, 0);
        }};
    }

    public static HashMap<Integer, Integer> match(Lottos lottos, List<Integer> winNumbers) throws IllegalArgumentException{
        List<Lotto> lottoList = lottos.getLottos();
        HashMap<Integer, Integer> matchResult = setUp();
        int matchCount;

        for (Lotto lotto : lottoList) {
            matchCount = LottoMatchCount.matchCount(lotto.getLotto(), winNumbers);
            putMatchResult(matchCount, matchResult);
        }

        return matchResult;
    }

    private static void putMatchResult(int matchCount, HashMap<Integer, Integer> matchResult) {
        int prize;

        if (matchCount >= MATCH_COUNT_STANDARD) {
            prize = Prize.checkMatchCount(matchCount).solvePrize();
            matchResult.put(prize, matchResult.getOrDefault(prize, 0) + 1);
        }
    }
}
