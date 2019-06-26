package lotto.view.result;

import lotto.domain.ticket.LottoTickets;
import lotto.dto.LottoResultDto;

public interface ResultView {
    void printLottoTickets(LottoTickets lottoTickets);
    void printResult(LottoResultDto lottoResultDto);
}
