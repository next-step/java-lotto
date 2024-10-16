package lotto.application;

import lotto.application.strategy.LottoNumberGenerator;
import lotto.domain.Lotto;

import java.util.List;

public class LottoProgram {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoProgram(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLottoTickets(int lottoTicketQuantity) {
        return lottoNumberGenerator.generate(lottoTicketQuantity);
    }

    public LottoWinningStatistics getWinningStatistics(List<Lotto> userLottoTicket, String[] winningLottoNumbersInput) {
        return new LottoWinningStatistics(userLottoTicket, new Lotto(winningLottoNumbersInput));
    }

}
