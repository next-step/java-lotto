package lotto.domain.statistics;

import java.util.Map;

public class LottoResult {

    private final int matchCount;
    private final String message;
    private final int prize;
    private final int prizeCount;

    public LottoResult(final LottoMatch lottoMatch, final LottoStatistics lottoStatistics) {
        LottoMatchKey lottoMatchKey = lottoMatch.getLottoMatchKey();
        matchCount = lottoMatchKey.getMatchCount();
        message = getMessage(lottoMatchKey);
        prize = lottoMatch.getPrize();
        prizeCount = getPrizeCount(lottoMatch, lottoStatistics);
    }

    private String getMessage(final LottoMatchKey lottoMatchKey) {
        String bonusMessage = "";
        if (lottoMatchKey.getMatchCount() == 5 && lottoMatchKey.getIsBonus()) {
            bonusMessage = ", 보너스 볼 일치";
        }
        return bonusMessage;
    }

    private int getPrizeCount(final LottoMatch lottoMatch, final LottoStatistics lottoStatistics) {
        Map<LottoMatch, Integer> resultMap = lottoStatistics.getStatistics();
        int count = 0;
        if (resultMap.containsKey(lottoMatch)) {
            count = resultMap.get(lottoMatch);
        }
        return count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }

    public int getPrizeCount() {
        return prizeCount;
    }
}
