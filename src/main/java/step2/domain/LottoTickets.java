package step2.domain;

import step2.dto.WinningInfo;

import java.util.*;

public class LottoTickets {
    private static final int ZERO = 0;

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

    public WinningResultInfo matchedWinningNumber(MatchedNumber matchedNumber, BonusBallNumber bonusBallNumber) {

        EnumMap<WinningCondition, WinningInfo> results = new EnumMap<>(WinningCondition.class);

        Arrays.stream(WinningCondition.values())
                .forEach(info -> results.put(info, new WinningInfo(info.getWinningPrize(), ZERO)));

        for (LottoTicket lottoTicket : lottoTickets) {
            WinningCondition condition = WinningCondition.calculateWinningRank(lottoTicket.matchedWinningNumber(matchedNumber),
                    lottoTicket.matchedBonusBallNumber(bonusBallNumber));

            results.put(condition, results.get(condition).addWinningCount());
        }

        return new WinningResultInfo(results);
    }
}
