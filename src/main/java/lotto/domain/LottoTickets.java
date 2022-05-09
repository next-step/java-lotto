package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public LottoPrizes check(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        return new LottoPrizes(
                lottoTickets
                        .stream()
                        .map(lottoTicket -> lottoTicket.check(lottoNumbers, bonusNumber))
                        .collect(Collectors.toList())
        );
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoTickets add(LottoTickets lottoTickets) {
        return new LottoTickets(
                Stream.concat(
                        this.lottoTickets.stream(),
                        lottoTickets.lottoTickets.stream()
                ).collect(Collectors.toList()));
    }

    public long size(LottoTicketType lottoTicketType) {
        return lottoTickets.stream()
                .filter(lottoTicket -> lottoTicket.isSameTicketType(lottoTicketType))
                .count();
    }
}
