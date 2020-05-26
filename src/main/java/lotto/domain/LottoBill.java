package lotto.domain;

import lotto.domain.number.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBill {
    private final List<LottoTicket> lottoTickets;

    public LottoBill(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int drawLotto(LottoTicket lottoTicket, List<LottoNumber> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(lottoTicket::isContainingLottoNumbers)
                .count();
    }


    public List<Integer> drawAllLotto(List<LottoNumber> winningNumbers) {
        return lottoTickets.stream()
                .map(lottoTicket -> drawLotto(lottoTicket, winningNumbers))
                .collect(Collectors.toList());
    }
}
