package lotto;

public class WinningLotto {

    private LottoTicket lottoTicket;

    private WinningLotto(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static WinningLotto of(LottoTicket lottoTicket) {
        return new WinningLotto(lottoTicket);
    }

    public boolean contains(Integer number) {
        return lottoTicket.contains(number);
    }

    public long containsNumberCount(LottoTicket lottoTicket) {
        return lottoTicket.getLottoNumbers()
                .stream()
                .filter(this::contains)
                .count();
    }
}
