package lotto.domain;

public class LottoTicketCount {
    private final int lottoTicketCount;

    public LottoTicketCount(String lottoTicketCount) {
        this(Integer.parseInt(lottoTicketCount));
    }

    public LottoTicketCount(int lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
    }
}
