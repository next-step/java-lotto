package step2.domain;

import step2.dto.WinningCondition;
import step2.dto.WinningInfo;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int lottoTicketsCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public WinningResultInfo matchedWinningNumber(MatchedNumber matchedNumber) {

        EnumMap<WinningCondition, WinningInfo> results = new EnumMap<>(WinningCondition.class);

        for (WinningCondition condition : WinningCondition.values()) {
            long matchedCount = lottoTickets.stream()
                    .map(lottoTicket -> lottoTicket.matchedWinningNumber(matchedNumber))
                    .filter(count -> count == condition.getMatchedCondition())
                    .count();

            results.put(condition, new WinningInfo(condition.getMatchedCondition(), condition.getWinningPrize(), matchedCount));
        }

        return new WinningResultInfo(results);
    }
}
