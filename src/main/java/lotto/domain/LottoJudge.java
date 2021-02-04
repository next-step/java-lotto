package lotto.domain;

public class LottoJudge {

    private final GoldenTicket goldenTicket;
    private final LottoTicket lottoTicket;

    public LottoJudge(GoldenTicket goldenTicket, LottoTicket lottoTicket) {
        this.goldenTicket = goldenTicket;
        this.lottoTicket = lottoTicket;
    }

    public Rank determine() {
        int count = this.goldenTicket.getMatchedNumbersCount(lottoTicket);
        boolean containsBonusBall = this.goldenTicket.containsBonusBall(lottoTicket);
        return Rank.of(count, containsBonusBall);
    }
}
