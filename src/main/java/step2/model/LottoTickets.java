package step2.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets create(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public int getTicketCount() {
        return this.lottoTickets.size();
    }

    public List<List<Integer>> getAllNumbers() {
        return this.lottoTickets.stream()
                .map(LottoTicket::getNumbers)
                .collect(Collectors.toList());
    }

    public LottoRankCount calculateLottoRankCount(List<Integer> winningNumbers) {
        LottoRankCount lottoRankCount = LottoRankCount.create();

        this.lottoTickets.forEach(lottoTicket -> {
            int matchCount = lottoTicket.getMatchCount(winningNumbers);
            lottoRankCount.plusCount(LottoRank.findRank(matchCount));
        });

        return lottoRankCount;
    }

    public int calculateWinningMoney(List<Integer> winningNumbers) {
        return this.lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.getMatchCount(winningNumbers))
                .map(LottoRank::findRank)
                .map(LottoRank::getWinningMoney)
                .reduce(0, Integer::sum);
    }
}
