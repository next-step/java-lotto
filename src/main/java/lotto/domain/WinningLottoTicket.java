package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket {
    private LottoTicket lottoTicket;
    private LottoNumber bonusNumber;

    public WinningLottoTicket(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public long getPrizeSum(List<LottoTicket> userLottoTickets) {
        long prizeSum = 0;
        for (LottoTicket userLottoTicket : userLottoTickets) {
            prizeSum += userLottoTicket.getWinningType(this.lottoTicket, this.bonusNumber).getPrize();
        }

        return prizeSum;
    }

    public List<WinningType> getWinningResult(List<LottoTicket> userLottoTicket) {
        return userLottoTicket.stream()
                .map(t -> t.getWinningType(this.lottoTicket, this.bonusNumber))
                .collect(Collectors.toList());
    }
}
