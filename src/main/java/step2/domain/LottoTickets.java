package step2.domain;

import step2.dto.WinningLotto;

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

//    public WinningResultInfo matchedWinningNumber1(MatchedNumber matchedNumber, BonusBallNumber bonusBallNumber) {
//
//        EnumMap<WinningCondition, WinningInfo> results = new EnumMap<>(WinningCondition.class);
//
//        Arrays.stream(WinningCondition.values())
//                .forEach(condition -> results.put(condition, new WinningInfo(condition.getWinningPrize(), ZERO)));
//
//        for (LottoTicket lottoTicket : lottoTickets) {
//            WinningCondition condition = WinningCondition.calculateWinningRank(lottoTicket.matchedWinningNumber(matchedNumber),
//                    lottoTicket.matchedBonusBallNumber(bonusBallNumber));
//
//            results.put(condition, results.get(condition).addWinningCount());
//        }
//
//        return new WinningResultInfo(results);
//    }

    public WinningResultInfo matchedWinningNumber(WinningLotto winningLotto) {

        EnumMap<WinningCondition, WinningInfo> results = new EnumMap<>(WinningCondition.class);

        Arrays.stream(WinningCondition.values())
                .forEach(condition -> results.put(condition, new WinningInfo(condition.getWinningPrize(), ZERO)));

        for (LottoTicket lottoTicket : lottoTickets) {
            WinningCondition condition = WinningCondition.calculateWinningRank(lottoTicket.matchedWinningNumber(winningLotto.getMatchedNumber()),
                    lottoTicket.matchedBonusBallNumber(winningLotto.getBonusBallNumber()));

            results.put(condition, results.get(condition).addWinningCount());
        }

        return new WinningResultInfo(results);
    }
}
