package lotto.controller;

import lotto.service.LottoService;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.dto.LottoResultCreateDTO;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoPrice;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoTickets purchaseLottoTickets(LottoPrice purchasePrice) {
        return lottoService.purchaseLottoTickets(LottoPurchaseDTO.from(purchasePrice.getLottoQuantity()));
    }

    public WinningLottoTicket getWinningLottoTicket(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        return lottoService.getWinningLottoTicket(winningLottoNumbers, bonusNumber);
    }

    public LottoResult checkLottoResult(LottoTickets purchaseLottoTickets, WinningLottoTicket winningLottoTicket) {
        return lottoService.checkLottoResult(LottoResultCreateDTO.of(purchaseLottoTickets, winningLottoTicket));
    }
}
