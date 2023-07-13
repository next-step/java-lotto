package lottogame.controller.resultcheck;

import java.util.List;
import java.util.Set;
import lottogame.controller.resultcheck.spi.ResultCheckInputer;
import lottogame.controller.resultcheck.spi.ResultCheckViewer;
import lottogame.domain.LottoCheckManager;
import lottogame.domain.LottoTicket;
import lottogame.domain.response.LottoCheckedResponse;

public class LottoResultCheckController {

    private final ResultCheckInputer resultCheckInputer;
    private final ResultCheckViewer resultCheckViewer;
    private final LottoCheckManager lottoCheckManager;

    public LottoResultCheckController(ResultCheckInputer resultCheckInputer, ResultCheckViewer resultCheckViewer,
        LottoCheckManager lottoCheckManager) {
        this.resultCheckInputer = resultCheckInputer;
        this.resultCheckViewer = resultCheckViewer;
        this.lottoCheckManager = lottoCheckManager;
    }

    public void checkResult(List<LottoTicket> lottoTickets) {
        Set<Integer> winningLottoNumbers = resultCheckInputer.inputWinningLottoNumbers();
        Integer bonusNumber = resultCheckInputer.inputBonusLottoNumber();

        LottoCheckedResponse lottoPrizes = lottoCheckManager.checkResult(lottoTickets);

        resultCheckViewer.draw(lottoPrizes);
    }
}
