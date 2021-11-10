package lotto.controller;

import lotto.service.LottoService;
import lotto.service.domain.LottoTicket;
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

    public LottoTicket getWinningLottoTicket(List<Integer> winningLottoNumbers) {
        return lottoService.getWinningLottoTicket(winningLottoNumbers);
    }

    public LottoResult checkLottoResult(LottoTickets purchaseLottoTickets, LottoTicket winningLottoTicket) {
        return lottoService.checkLottoResult(LottoResultCreateDTO.of(purchaseLottoTickets, winningLottoTicket));
    }
}
