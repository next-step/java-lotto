package lotto.domain;

import java.util.List;

public class Scanner {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public Scanner(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void scan(LottoTicket lottoTicket, LottoResult lottoResult) {
        long matchingScore = lottoTicket.getLottoNumbers().stream()
                        .filter(n -> winningNumbers.contains(n.toInt())).count();
        final boolean matchBonus = lottoTicket.getLottoNumbers().stream()
                .anyMatch(n -> n.toInt() == bonusNumber);

        lottoResult.saveLottoResult(Long.valueOf(matchingScore).intValue(), matchBonus);
    }

    public LottoResult scanAll(List<LottoTicket> lottoTickets) {
        LottoResult lottoResult = new LottoResult(lottoTickets.size());
        lottoTickets.forEach(lottoTicket -> scan(lottoTicket, lottoResult));
        return lottoResult;
    }
}
