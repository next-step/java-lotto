package lotto.domain;

public class WinTicket {

    private LottoTicket winTicket;
    private LottoNumber bonusNumber;

    public WinTicket(String text, int bonusInt) {
        this.winTicket = new LottoTicket(text);
        this.bonusNumber = LottoNumber.of(bonusInt);
    }

    public Rank calculateRank(LottoTicket lottoTicket) {
        int matchCount = lottoTicket.getMatchCount(winTicket);
        boolean bonusMatch = lottoTicket.contains(bonusNumber);
        return Rank.findByMatchCountAndBonusMatch(matchCount, bonusMatch);
    }
}
