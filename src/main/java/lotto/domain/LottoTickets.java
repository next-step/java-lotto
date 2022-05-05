package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        validate(lottoTickets);
        this.lottoTickets = lottoTickets;
    }

    private void validate(List<LottoTicket> lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("lottoTickets는 null이거나 빈 값 일 수 없습니다.");
        }
    }

    public LottoPrizes check(LottoNumbers lottoNumbers) {
        return new LottoPrizes(
                lottoTickets
                        .stream()
                        .map(lottoTicket -> lottoTicket.check(lottoNumbers))
                        .collect(Collectors.toList())
        );
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
