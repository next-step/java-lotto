package lotto.service;

import lotto.domain.LottoRanks;
import lotto.domain.LottoTicket;

import java.util.List;

public class LottoWinService {

    public LottoRanks inquiryWin(List<String> confirmTargetList, int[] winNumbers, int bonusNumber) {
        LottoTicket lottoTicket = new LottoTicket(confirmTargetList);
        return lottoTicket.inquiryRankList(winNumbers, bonusNumber);
    }
}
