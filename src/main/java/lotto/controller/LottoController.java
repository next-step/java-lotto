package lotto.controller;

import lotto.controller.dto.LottoPurchaseParam;
import lotto.controller.dto.LottoResultParam;
import lotto.controller.dto.PurchaseLottoTicketsDTO;
import lotto.controller.dto.WinningLottoTicketParam;
import lotto.service.LottoService;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.ui.ResultView;

public class LottoController {
    private final LottoService lottoService;
    private final ResultView resultView;

    public LottoController(LottoService lottoService, ResultView resultView) {
        this.lottoService = lottoService;
        this.resultView = resultView;
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseParam lottoPurchaseParam) {
        Integer manualLottoCount = lottoPurchaseParam.getManualLottoCount();

        LottoTickets purchaseLottoTickets = lottoService.purchaseLottoTickets(lottoPurchaseParam.getAutoLottoQuantity(),
                                                                              lottoPurchaseParam.getLottoNumbersList());

        resultView.printPurchaseLottoTickets(
                PurchaseLottoTicketsDTO.of(manualLottoCount,
                                           purchaseLottoTickets.getAutoLottoCount(manualLottoCount),
                                           purchaseLottoTickets));
        return purchaseLottoTickets;
    }

    public WinningLottoTicket getWinningLottoTicket(WinningLottoTicketParam winningLottoTicketParam) {
        return lottoService.getWinningLottoTicket(winningLottoTicketParam.getWinningLottoNumbers(),
                                                  winningLottoTicketParam.getBonusNumber());
    }

    public void checkLottoResult(LottoResultParam lottoResultParam) {
        LottoResult lottoResult = lottoService.checkLottoResult(lottoResultParam.getPurchaseLottoTickets(),
                                                                lottoResultParam.getWinningLottoTicket());
        resultView.printLottoResult(lottoResult, lottoResultParam.getLottoPrice());
    }
}
