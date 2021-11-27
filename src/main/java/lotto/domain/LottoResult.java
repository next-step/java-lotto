package lotto.domain;

public class LottoResult {

    private final long matchCount;
    private final boolean matchBonus;

    private LottoResult(long matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static LottoResult of(WinnerLottoTicket winnerLottoTicket, LottoTicket lottoTicket) {
        long count = winnerLottoTicket.findLottoMatchCount(lottoTicket);
        boolean matchBonus = lottoTicket.contains(winnerLottoTicket.getBonusNumber());

        return new LottoResult(count, matchBonus);
    }

    public long getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
