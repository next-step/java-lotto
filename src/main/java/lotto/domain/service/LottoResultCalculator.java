package lotto.domain.service;

import lotto.domain.model.*;

import java.util.List;

public class LottoResultCalculator {
    public static MatchResult evaluateLottos(WinningTicket winningTicket, List<LottoTicket> lottos) {
        MatchResult matchResult = new MatchResult();
        for (LottoTicket lotto : lottos) {
            Rank rank = winningTicket.evaluate(lotto);
            matchResult.addRank(rank);
        }
        return matchResult;
    }
}
