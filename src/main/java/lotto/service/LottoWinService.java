package lotto.service;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRanks;
import lotto.domain.LottoTickets;

public class LottoWinService {

    public LottoRanks inquiryWin(LottoTickets purchaseTickets, LottoNumbers winNumbers, LottoNumber bonusNumber) {
        return purchaseTickets.ranks(winNumbers, bonusNumber);
    }
}
