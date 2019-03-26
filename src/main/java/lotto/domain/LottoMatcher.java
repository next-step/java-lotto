package lotto.domain;

import lotto.dto.LottoMatchResult;
import lotto.dto.UserLotto;
import lotto.dto.WinningLotto;

import java.util.List;

public class LottoMatcher {
    public static void resultLottoMatch() {
        LottoMatchResult.createMatchTable();
        for (LottoTicket ticket : UserLotto.getUserLotto()) {
            LottoMatchResult.addMatchResult(matchNumberCount(ticket));
        }
    }

    public static int matchNumberCount(LottoTicket ticket) {
        List<Integer> winingLottoNumbers = WinningLotto.getWinningLotto();
        final int[] matchCount = {0};
        ticket.getTicket().stream().forEach(number -> {
            if (winingLottoNumbers.contains(number)) {
                matchCount[0] += 1;
            }
        });

        return matchCount[0];
    }
}
