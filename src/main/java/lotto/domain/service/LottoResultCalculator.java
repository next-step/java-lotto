package lotto.domain.service;

import lotto.domain.model.*;

import java.util.List;

public class LottoResultCalculator {
    public static MatchResult evaluateLottos(WinningTicket winningTicket, List<LottoTicket> lottos) {
        MatchResult matchResult = new MatchResult();
        for (LottoTicket lotto : lottos) {
            Rank rank = evaluate(winningTicket, lotto);
            matchResult.addRank(rank);
        }
        return matchResult;
    }

    private static Rank evaluate(WinningTicket winningTicket, LottoTicket lotto) {
        int countOfMatch = (int) winningTicket.getWinNumbers().stream()
                .filter(lotto::contains)
                .count();
        boolean matchBonus = lotto.contains(winningTicket.getBonusNumber());
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
