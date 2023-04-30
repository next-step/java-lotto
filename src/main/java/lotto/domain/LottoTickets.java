package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<List<Integer>> lottoNumbers) {
        List<LottoTicket> lottoTickets = lottoNumbers.stream()
                .map(LottoTicket::of)
                .collect(Collectors.toList());

        return new LottoTickets(lottoTickets);
    }

    public List<LottoPrize> getWinningPrizes(List<Integer> winningNumbers, LottoNumber bonusNumber) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.getWinningPrize(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
