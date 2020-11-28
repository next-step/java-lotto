package lotto.domain;

import java.util.List;

public class Scanner {

    private List<Integer> winningNumbers;
    private LottoResult lottoResult;

    public Scanner(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    private void scan(LottoTicket lottoTicket) {
        long matchingScore = lottoTicket.getNumbers().stream()
                        .filter(n -> winningNumbers.contains(n)).count();
        lottoResult.saveLottoResult(matchingScore);
    }

    public LottoResult scanAll(List<LottoTicket> lottoTickets) {
        lottoResult = new LottoResult(lottoTickets.size());
        lottoTickets.forEach(this::scan);
        lottoResult.calculateProfitRatio();
        return lottoResult;
    }
}
