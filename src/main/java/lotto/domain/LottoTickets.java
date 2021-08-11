package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoTickets {

    private static final int BONUS_TARGET_MATCH_COUNT = 5;

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public LottoStatistic matchLottoTickets(final WinningLottoTicket winningLottoTicket) {
        List<LottoRank> lottoStatistic = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            LottoRank lottoRank = findLottoRank(lottoTicket, winningLottoTicket);
            lottoStatistic.add(lottoRank);
        }
        return new LottoStatistic(lottoStatistic);
    }

    private LottoRank findLottoRank(LottoTicket lottoTicket, WinningLottoTicket winningLottoTicket) {
        int matchCount = lottoTicket.matchLottoTicket(winningLottoTicket);
        if (matchCount != BONUS_TARGET_MATCH_COUNT) {
            return LottoRank.of(matchCount, false);
        }

        if(winningLottoTicket.bonusBallMatch(lottoTicket)) {
            return LottoRank.SECOND_PLACE;
        }
        return LottoRank.of(matchCount, false);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}