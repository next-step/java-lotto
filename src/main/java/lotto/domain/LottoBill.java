package lotto.domain;

import lotto.domain.number.LottoWinningNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBill {
    private final List<LottoTicket> lottoTickets;

    public LottoBill(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoResult drawAllLotto(LottoWinningNumber lottoWinningNumber) {
        return lottoTickets.stream()
                .map(lottoWinningNumber::findMatchingSheet)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoResult::new));
    }
}
