package lotto.controller;

import lotto.controller.dto.LottoTicketPurchaseRequest;
import lotto.controller.dto.LottoTicketPurchaseResponse;
import lotto.domain.Lotto;
import lotto.domain.LottoTicketType;
import lotto.domain.LottoTickets;
import lotto.service.LottoPurchaseService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPurchaseController {

    private final LottoPurchaseService lottoAutoService;

    public LottoPurchaseController() {
        this.lottoAutoService = new LottoPurchaseService();
    }

    public LottoTicketPurchaseRequest validatePurchasable(LottoTicketPurchaseRequest request) {
        lottoAutoService.validatePurchasable(request.getPurchaseAmount(), request.getManualLottoPurchaseCount());
        return request;
    }

    public LottoTicketPurchaseResponse purchaseLottoTicket(LottoTicketPurchaseRequest request) {
        return assembleLottoTicketPurchaseResponse(request);
    }

    private LottoTicketPurchaseResponse assembleLottoTicketPurchaseResponse(LottoTicketPurchaseRequest request) {
        LottoTickets lottoTickets = lottoAutoService.purchaseLottoTickets(request.getPurchaseAmount(), request.getManualLottoPurchaseNumberList());
        return new LottoTicketPurchaseResponse(lottoTickets.calculateLottoCount(LottoTicketType.MANUAL), lottoTickets.calculateLottoCount(LottoTicketType.AUTO), assembleLottoNumberList(lottoTickets.getLottoList()));
    }

    private List<String> assembleLottoNumberList(List<Lotto> lottoList) {
        return lottoList.stream().map(lotto -> Arrays.toString(lotto.getLottoNumbers())).collect(Collectors.toList());
    }

}
