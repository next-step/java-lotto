package lotto.domain;

public class WinningLotto {

    private final LottoTicket lottoTicket;

    public WinningLotto(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public WinningRank match(LottoTicket ticket) {
        int matchCount = countOfMatch(ticket);
        return WinningRank.valueOf(matchCount);
    }

    public int countOfMatch(LottoTicket ticket) {
        return (int) ticket.getLottoNumbers()
                .stream()
                .filter(lottoTicket::containsLottoNumber)
                .count();
    }

    public LottoTicket findWinningLotto() {
        return lottoTicket;
    }

    public WinningStatistics calculateLottoStatistics(LottoTickets lottoTickets) {
        WinningStatistics winningStatistics = new WinningStatistics();

        for (LottoTicket ticket : lottoTickets.getLottoTickets()) {
            WinningRank rank = match(ticket);
            winningStatistics.addMatchedTicket(rank);
        }
        return winningStatistics;
    }
}


