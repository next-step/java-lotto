package lottogame.controller.resultcheck;

import java.util.List;
import java.util.Set;
import lottogame.controller.resultcheck.spi.ResultCheckInputer;
import lottogame.controller.resultcheck.spi.ResultCheckViewer;
import lottogame.domain.LottoPrize;
import lottogame.domain.LottoTicket;
import lottogame.service.LottoCheckService;

public class LottoResultCheckController {

    private final ResultCheckInputer resultCheckInputer;
    private final ResultCheckViewer resultCheckViewer;
    private final LottoCheckService lottoCheckService;

    public LottoResultCheckController(ResultCheckInputer resultCheckInputer, ResultCheckViewer resultCheckViewer,
        LottoCheckService lottoCheckService) {
        this.resultCheckInputer = resultCheckInputer;
        this.resultCheckViewer = resultCheckViewer;
        this.lottoCheckService = lottoCheckService;
    }

    public void checkResult(List<LottoTicket> lottoTickets) {
        Set<Integer> winningLottoNumbers = resultCheckInputer.inputWinningLottoNumbers();
        Integer bonusNumber = resultCheckInputer.inputBonusLottoNumber();

        List<LottoPrize> lottoPrizes = lottoCheckService.checkResult(lottoTickets, winningLottoNumbers, bonusNumber);

        resultCheckViewer.draw(lottoPrizes);
    }

}
