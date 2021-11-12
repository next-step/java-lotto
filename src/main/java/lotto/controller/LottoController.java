package lotto.controller;

import lotto.controller.dto.PurchaseLottoTicketsDTO;
import lotto.service.LottoService;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.dto.LottoResultCreateDTO;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoPrice;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(LottoService lottoService, InputView inputView, ResultView resultView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public LottoTickets purchaseLottoTickets() {
        LottoPrice purchasePrice = inputView.inputPurchasePrice();
        Integer manualLottoCount = inputView.inputManualCount();
        List<List<Integer>> manualNumbers = inputView.inputManualLottoNumbers(manualLottoCount);

        LottoTickets purchaseLottoTickets
                = lottoService.purchaseLottoTickets(
                LottoPurchaseDTO.from(purchasePrice.getLottoQuantity(), manualNumbers));

        resultView.printPurchaseLottoTickets(PurchaseLottoTicketsDTO.create(manualLottoCount,
                                                                            purchaseLottoTickets.getCountOfLottoTickets() - manualLottoCount,
                                                                            purchaseLottoTickets));
        return purchaseLottoTickets;
    }

    public WinningLottoTicket getWinningLottoTicket() {
        List<Integer> winningLottoNumbers = inputView.inputWinningLottoNumberOfLastWeeks();
        Integer bonusNumber = inputView.inputBonusNumber();

        return lottoService.getWinningLottoTicket(winningLottoNumbers, bonusNumber);
    }

    public void checkLottoResult(LottoTickets purchaseLottoTickets, WinningLottoTicket winningLottoTicket) {
        LottoResult lottoResult
                = lottoService.checkLottoResult(LottoResultCreateDTO.of(purchaseLottoTickets, winningLottoTicket));
        resultView.printLottoResult(lottoResult, purchaseLottoTickets.getLottoPrice());
    }
}
