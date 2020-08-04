package camp.nextstep.edu.rebellion.lotto.domain.winning;

import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoTicket;

import java.util.stream.Collectors;

public class LottoTicketMatcher {
    private LottoTicketMatcher(){}

    public static LottoWinningResult match(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        return lottoTicket.getLottoNumbers()
                .stream()
                .map(lottoNumber -> lottoWinningNumber.getMatchResult(lottoNumber))
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoWinningResult::new));
    }
}
