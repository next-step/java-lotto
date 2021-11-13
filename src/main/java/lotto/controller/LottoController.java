package lotto.controller;

import lotto.controller.dto.PurchaseLottoTicketsDTO;
import lotto.service.LottoService;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.dto.LottoResultCreateDTO;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.ui.ResultView;
import lotto.validator.LottoValidator;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final ResultView resultView;

    public LottoController(LottoService lottoService, ResultView resultView) {
        this.lottoService = lottoService;
        this.resultView = resultView;
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseDTO lottoPurchaseDTO) {
        Integer manualLottoCount = lottoPurchaseDTO.getLottoNumbersList().size();

        LottoTickets purchaseLottoTickets = lottoService.purchaseLottoTickets(lottoPurchaseDTO);

        resultView.printPurchaseLottoTickets(
                PurchaseLottoTicketsDTO.of(manualLottoCount,
                                           purchaseLottoTickets.getAutoLottoCount(manualLottoCount),
                                           purchaseLottoTickets));
        return purchaseLottoTickets;
    }

    public WinningLottoTicket getWinningLottoTicket(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        LottoValidator.checkBonusNumber(winningLottoNumbers, bonusNumber);
        return lottoService.getWinningLottoTicket(winningLottoNumbers, bonusNumber);
    }

    public void checkLottoResult(LottoTickets purchaseLottoTickets, WinningLottoTicket winningLottoTicket) {
        LottoResult lottoResult
                = lottoService.checkLottoResult(LottoResultCreateDTO.of(purchaseLottoTickets, winningLottoTicket));
        resultView.printLottoResult(lottoResult, purchaseLottoTickets.getLottoPrice());
    }
}
