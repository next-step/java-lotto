package lotto.domain;

import lotto.pattern.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGroup {

    private final List<LottoTicket> lottoTicketGroup;

    public LottoTicketGroup(Pay pay, NumberGenerator numberGenerator) {
        this(generateLottoTicketGroup(pay.getTicketCount(), numberGenerator));
    }

    public LottoTicketGroup(List<LottoTicket> lottoTickets) {
        this.lottoTicketGroup = lottoTickets;
    }

    private static List<LottoTicket> generateLottoTicketGroup(int ticketCount, NumberGenerator numberGenerator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new LottoTicket(numberGenerator.generateLottoNumbers()));
        }
        return lottoTickets;
    }

    public List<LottoTicket> getTickets() {
        return this.lottoTicketGroup;
    }

    public RankGroup getLottoRankings(WinningLotto winningLotto) {
        List<Rank> myRanks = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTicketGroup) {
            myRanks.add(Rank.of(lottoTicket.getMatchResult(winningLotto), lottoTicket.hasLottoNumber(winningLotto.getBonusNumber())));
        }
        return new RankGroup(myRanks);
    }
}