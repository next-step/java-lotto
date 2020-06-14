package camp.nextstep.edu.nextstep8.lotto;

import java.util.stream.Collectors;

public class LottoMatcher {
    private LottoMatcher(){}

    public static LottoWinningResult match(LottoTicket lottoTicket, LottoWinnerNumber winnerNumber) {
        return lottoTicket.getLottoNumbers().stream()
                .map(n -> winnerNumber.getMatchCount(n))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        LottoWinningResult::new));
    }
}
