package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningTicket {

    private LottoTicket winningNumber;
    private LottoNumber bonusNumber;


    public WinningTicket(List<Integer> winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = new LottoTicket(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoRank, Integer> countMatching(LottoTickets lottoTickets) {
        return lottoTickets.calculateSameNumberCounts(winningNumber, bonusNumber);
    }
}
