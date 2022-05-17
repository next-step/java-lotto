package lotto.domain;

import lotto.pattern.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(Pay pay, NumberGenerator numberGenerator) {
        this(generateLottoTickets(pay.getAutoTicketCount(), numberGenerator));
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets merge(LottoTickets lottoTickets) {
        this.lottoTickets.addAll(lottoTickets.getTickets());
        return new LottoTickets(this.lottoTickets);
    }

    private static List<LottoTicket> generateLottoTickets(int ticketCount, NumberGenerator numberGenerator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new LottoTicket(numberGenerator.generateLottoNumbers()));
        }
        return lottoTickets;
    }

    public List<LottoTicket> getTickets() {
        return this.lottoTickets;
    }

    public Ranks getLottoRankings(WinningLotto winningLotto) {
        List<Rank> myRanks = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            myRanks.add(Rank.of(lottoTicket.getMatchResult(winningLotto), lottoTicket.hasLottoNumber(winningLotto.getBonusNumber())));
        }
        return new Ranks(myRanks);
    }
}