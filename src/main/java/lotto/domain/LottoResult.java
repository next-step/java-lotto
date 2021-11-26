package lotto.domain;

public class LottoResult {

    // TODO : 당첨번호와 구매번호를 비교하는 로직을 어디에 두어야 할까.

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
