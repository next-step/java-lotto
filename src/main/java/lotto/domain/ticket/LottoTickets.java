package lotto.domain.ticket;

import lotto.domain.prize.Prize;
import lotto.exception.ErrorMessage;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(final List<LottoTicket> lottoTickets) {
        validate(lottoTickets);
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(final List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    private void validate(final List<LottoTicket> lottoTickets) {
        if (lottoTickets == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public Map<Prize, Long> matchPrizes(final WinningLottoTicket winningLottoTicket) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.matchPrize(winningLottoTicket))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
