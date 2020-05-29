package step2.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets newInstance(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<List<Integer>> getNumberGroups() {
        return this.lottoTickets.stream()
                .map(LottoTicket::getNumbers)
                .collect(Collectors.toList());
    }

    public int getCount() {
        return this.lottoTickets.size();
    }

    public LottoRankCount getLottoRankCount(List<Integer> winningNumbers) {
        LottoRankCount lottoRankCount = LottoRankCount.newInstance();

        this.lottoTickets.forEach(lottoTicket -> {
            int matchCount = lottoTicket.getMatchCount(winningNumbers);
            lottoRankCount.plusCount(LottoRank.findRank(matchCount));
        });

        return lottoRankCount;
    }

    public int getTotalWinningMoney(List<Integer> winningNumbers) {
        return this.lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.getMatchCount(winningNumbers))
                .map(LottoRank::findRank)
                .map(LottoRank::getWinningMoney)
                .reduce(0, Integer::sum);
    }
}
