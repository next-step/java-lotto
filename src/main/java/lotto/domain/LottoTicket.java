package lotto.domain;

import lotto.dto.WinningLotto;
import java.util.List;

public class LottoTicket {
    private List<Integer> ticket;
    private int matchCount;

    public LottoTicket(ILottoGenerator lottoGenerator) {
        ticket = lottoGenerator.createLottoNumbers();
        matchCount = 0;
    }

    public List<Integer> getTicket() {
        return this.ticket;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public void addTicketMatchCount(WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getWinningLotto();

        ticket.stream().forEach(number -> {
            if (winningNumbers.contains(number)) {
                matchCount += 1;
            }
        });
    }
}
