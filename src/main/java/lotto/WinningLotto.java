package lotto;

public class WinningLotto {

    private LottoTicket lottoTicket;
    private Integer bonusNumber;

    private WinningLotto(LottoTicket lottoTicket, Integer bonusNumber) {
        validate(lottoTicket, bonusNumber);
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(LottoTicket lottoTicket, Integer bonusNumber) {
        return new WinningLotto(lottoTicket, bonusNumber);
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

    private void validate(LottoTicket lottoTicket, Integer bonusNumber) {
        if (lottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 이미 포함되어 있습니다.");
        }
    }
}
