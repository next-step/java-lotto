package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final LottoTickets lottoTickets;
    private final List<Integer> winningNumbers;

    public LottoGame(LottoTickets lottoTickets, List<Integer> winningNumbers) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
    }

    public LottoResult getLottoResult() {
        List<Integer> winningCounts = getWinningCounts();
        return new LottoResult(winningCounts);
    }

    private List<Integer> getWinningCounts() {
        return lottoTickets.getLottoTickets().stream()
                .map(lottoTicket -> lottoTicket.matchesLottoNumberCount(winningNumbers))
                .collect(Collectors.toList());
    }
}
