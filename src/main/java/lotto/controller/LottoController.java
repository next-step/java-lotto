package lotto.controller;

import lotto.controller.dto.LottoPurchaseRequest;
import lotto.service.LottoService;
import lotto.service.domain.LottoTicket;
import lotto.service.domain.LottoTicketRandomMaker;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.dto.LottoResultCreateDTO;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoPrice;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService(new LottoTicketRandomMaker());
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseRequest request) {
        Integer lottoQuantity = getLottoQuantity(request.getPurchasePrice());
        return lottoService.purchaseLottoTickets(LottoPurchaseDTO.from(lottoQuantity));
    }

    public LottoTicket getWinningLottoTicket(List<Integer> winningLottoNumbers) {
        return lottoService.getWinningLottoTicket(winningLottoNumbers);
    }

    public LottoResult checkLottoResult(LottoTickets purchaseLottoTickets, LottoTicket winningLottoTicket) {
        return lottoService.checkLottoResult(LottoResultCreateDTO.of(purchaseLottoTickets, winningLottoTicket));
    }

    private Integer getLottoQuantity(LottoPrice purchasePrice) {
        return purchasePrice.getLottoQuantity();
    }
}
