package lottogame.controller;

import java.util.List;
import java.util.Set;
import lottogame.controller.spi.ResultCheckInputer;
import lottogame.controller.spi.ResultCheckViewer;
import lottogame.domain.LottoTicket;
import lottogame.service.LottoService;
import lottogame.service.response.LottoCheckResponse;

public class LottoResultCheckController {

    private final ResultCheckInputer resultCheckInputer;
    private final ResultCheckViewer resultCheckViewer;
    private final LottoService lottoCheckService;

    public LottoResultCheckController(ResultCheckInputer resultCheckInputer, ResultCheckViewer resultCheckViewer,
        LottoService lottoCheckService) {
        this.resultCheckInputer = resultCheckInputer;
        this.resultCheckViewer = resultCheckViewer;
        this.lottoCheckService = lottoCheckService;
    }

    public void checkResult(List<LottoTicket> lottoTickets) {
        Set<Integer> winningLottoNumbers = resultCheckInputer.inputWinningLottoNumbers();
        Integer bonusNumber = resultCheckInputer.inputBonusLottoNumber();

        LottoCheckResponse lottoPrizes = lottoCheckService.checkResult(lottoTickets, winningLottoNumbers, bonusNumber);

        resultCheckViewer.draw(lottoPrizes);
    }
}
