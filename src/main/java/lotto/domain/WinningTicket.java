package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningTicket {

    private LottoTicket winningNumber;
    private int bonusNumber;


    public WinningTicket(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = new LottoTicket(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoRank, Integer> countMatching(LottoTickets lottoTickets) {
        return lottoTickets.calculateSameNumberCounts(winningNumber, bonusNumber);
    }
}
