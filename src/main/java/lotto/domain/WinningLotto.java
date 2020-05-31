package lotto.domain;

import lotto.domain.ticket.LottoTicket;

public class WinningLotto {

    private LottoTicket lottoTicket;
    private LottoNumber bonusNumber;

    private WinningLotto(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        validate(lottoTicket, bonusNumber);
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        return new WinningLotto(lottoTicket, bonusNumber);
    }

    public boolean contains(Integer number) {
        return lottoTicket.contains(number);
    }

    public long getContainNumberCount(LottoTicket lottoTicket) {
        return lottoTicket.getLottoNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .filter(this::contains)
                .count();
    }

    public boolean isBonusMatch(LottoTicket lottoTicket) {
        return lottoTicket.contains(bonusNumber.getNumber());
    }

    private void validate(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("보너스 번호가 이미 포함되어 있습니다.");
        }
    }
}
