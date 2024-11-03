package lotto.util;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

public class WinningUtils {

    private WinningUtils() {
    }

    public static LottoResult countMatchingNumbers(LottoTicket userTicket, LottoTicket winningTicket) {
        int matchCount = userTicket.countMatchingNumbers(winningTicket);
        boolean isBonus = userTicket.isBonusMatched(winningTicket);
        return new LottoResult(matchCount, isBonus);
    }
}
