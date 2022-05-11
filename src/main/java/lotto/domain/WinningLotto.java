package lotto.domain;

import lotto.exceptions.DuplicateLottoNumberException;

import java.util.List;

public class WinningLotto {
    private final LottoTicket lottoTicket;
    private final LottoNumber lottoNumber;

    public WinningLotto(LottoTicket lottoTicket, LottoNumber lottoNumber) {
        validateDuplicateLottoNumber(lottoTicket, lottoNumber);
        this.lottoTicket = lottoTicket;
        this.lottoNumber = lottoNumber;
    }

    private void validateDuplicateLottoNumber(LottoTicket lottoTicket, LottoNumber lottoNumber) {
        if(lottoTicket.hasLottoNumber(lottoNumber)) {
            throw new DuplicateLottoNumberException();
        }
    }

    public List<LottoNumber> getLottoTicket() {
        return lottoTicket.getLottoTicket();
    }

    public LottoNumber getBonusNumber() {
        return lottoNumber;
    }
}
