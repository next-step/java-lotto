package lotto.domain;

import lotto.constant.Constant;
import lotto.view.InputView;

import java.util.HashMap;
import java.util.List;

public class LottoMatch {
    private static final HashMap<Integer, Integer> matchResult = new HashMap<>(){{
            put(Rank.FIFTH.getPrize(), 0);
            put(Rank.FOURTH.getPrize(), 0);
            put(Rank.THIRD.getPrize(), 0);
            put(Rank.SECOND.getPrize(), 0);
            put(Rank.FIRST.getPrize(), 0);
    }};

    public static HashMap<Integer, Integer> matchWinNumber(Lottos lottos, List<Integer> winNumbers, Bonus bonus) throws IllegalArgumentException{
        int matchCount;

        for (Lotto lotto : lottos.getLottos()) {
            List<LottoNumber> lottoNumbers = lotto.getLotto();
            matchCount = LottoMatchCount.matchCount(lottoNumbers, winNumbers);
            putMatchResult(matchCount, isMatchBonus(lottoNumbers, bonus));
        }

        return matchResult;
    }

    private static void putMatchResult(int matchCount, boolean matchBonus) {
        int prize = prizeFromRank(matchCount, matchBonus);

        if (prize == 0) {
            return;
        }

        matchResult.put(prize, matchResult.getOrDefault(prize, 0) + 1);
    }

    private static int prizeFromRank(int matchCount, boolean matchBonus) {
        if (matchBonus) {
            matchCount += 1;
        }
        return Rank.valueOf(matchCount, matchBonus).getPrize();
    }

    private static boolean isMatchBonus(List<LottoNumber> lottoNumbers, Bonus bonus) {
        return lottoNumbers.contains(new LottoNumber(bonus.getBonus()));
    }

}
