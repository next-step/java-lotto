package lotto.service;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRanks;
import lotto.domain.LottoTickets;

public class LottoWinService {

    public LottoRanks inquiryWin(LottoTickets purchaseTickets, LottoNumbers winNumbers) {
        return purchaseTickets.ranks(winNumbers);
    }
}
