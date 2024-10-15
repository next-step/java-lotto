package lotto.application;

import lotto.application.strategy.LottoNumberGenerator;
import lotto.domain.LottoNumbers;

import java.util.List;

public class LottoProgram {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoProgram(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<LottoNumbers> generateLottoTickets(int lottoTicketQuantity) {
        return lottoNumberGenerator.generate(lottoTicketQuantity);
    }

    public LottoWinningStatistics getWinningStatistics(List<LottoNumbers> userLottoTicket, String[] winningLottoNumbersInput) {
        return new LottoWinningStatistics(userLottoTicket, new LottoNumbers(winningLottoNumbersInput));
    }

}
