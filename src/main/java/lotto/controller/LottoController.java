package lotto.controller;

import lotto.controller.dto.LottoPurchaseRequest;
import lotto.service.LottoService;
import lotto.service.domain.LottoTicketRandomGenerator;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.model.LottoTicket;
import lotto.service.model.LottoTickets;

import java.util.List;

public class LottoController {
    private static final Integer MINIMUM_PRICE = 1_000;

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService(new LottoTicketRandomGenerator());
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseRequest request) {
        Integer purchaseQuantity = getPurchaseQuantity(request.getPurchasePrice());
        return lottoService.purchaseLottoTickets(LottoPurchaseDTO.from(purchaseQuantity));
    }

    public LottoTicket getWinningLottoTicket(List<Integer> winningNumbers) {
        return lottoService.getWinningLottoTicket(winningNumbers);
    }

    private Integer getPurchaseQuantity(Integer purchasePrice) {
        return purchasePrice / MINIMUM_PRICE;
    }
}
