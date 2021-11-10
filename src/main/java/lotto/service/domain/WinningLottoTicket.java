package lotto.service.domain;

import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;

import java.util.List;

public class WinningLottoTicket {
    private final LottoTicket lottoTicket;
    private final LottoNumber bonusNumber;

    private WinningLottoTicket(List<LottoNumber> winningNumbers, Integer bonusNumber) {
        Preconditions.checkNotNull(winningNumbers, "winningNumbers는 필수값 입니다.");
        Preconditions.checkNotNull(bonusNumber, "bonusNumber 필수값 입니다.");

        this.lottoTicket = LottoTicket.from(winningNumbers);
        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    public static WinningLottoTicket of(List<LottoNumber> winningNumbers, Integer bonusNumber) {
        return new WinningLottoTicket(winningNumbers, bonusNumber);
    }

    public Integer getCountOfMatch(LottoTicket purchaseLottoTicket) {
        return lottoTicket.getCountOfMatch(purchaseLottoTicket);
    }

    public boolean isBonusNumberMatch(LottoTicket purchaseLottoTicket) {
        return purchaseLottoTicket.isContains(bonusNumber);
    }
}
