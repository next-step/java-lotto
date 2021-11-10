package lotto.service.domain;

import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;

import java.util.List;

public class WinningLottoTicket {
    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusNumber;

    private WinningLottoTicket(List<LottoNumber> winningLottoNumbers, Integer bonusNumber) {
        Preconditions.checkNotNull(winningLottoNumbers, "winningLottoNumbers는 필수값 입니다.");
        Preconditions.checkNotNull(bonusNumber, "bonusNumber 필수값 입니다.");

        this.winningLottoTicket = LottoTicket.from(winningLottoNumbers);
        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    public static WinningLottoTicket of(List<LottoNumber> winningLottoNumbers, Integer bonusNumber) {
        return new WinningLottoTicket(winningLottoNumbers, bonusNumber);
    }

    public Integer getCountOfMatch(LottoTicket lottoTicket) {
        return winningLottoTicket.getCountOfMatch(lottoTicket);
    }

    public boolean isBonusNumberMatch(LottoTicket myLottoTicket) {
        return myLottoTicket.isContains(bonusNumber);
    }
}
