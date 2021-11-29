package lotto.controller;

import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.dto.LottoResultDto;
import lotto.domain.dto.WinningNumberDto;
import lotto.service.LottoTicketBooth;
import lotto.service.WinningResult;

public class LottoController {

    private static class LottoControllerHolder {

        private static final LottoController LOTTO_CONTROLLER = new LottoController();
    }

    private final WinningResult winningResult;
    private final LottoTicketBooth lottoTicketBooth;

    private LottoController() {
        winningResult = WinningResult.getInstance();
        lottoTicketBooth = LottoTicketBooth.getInstance();
    }

    public static LottoController getInstance() {
        return LottoControllerHolder.LOTTO_CONTROLLER;
    }

    public LottoTickets buyLottoTickets(Money money, List<String> manualLottoNumbers) {
        LottoTickets lottoTickets = lottoTicketBooth.generate(money);
        return lottoTickets.sum(lottoTicketBooth.generate(manualLottoNumbers));
    }

    public LottoResultDto lottoResult(LottoTickets lottoTickets, WinningNumberDto winningNumberDto) {
        return winningResult.winningResult(lottoTickets, winningNumberDto);
    }

}
