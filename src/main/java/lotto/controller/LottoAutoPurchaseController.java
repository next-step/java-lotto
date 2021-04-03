package lotto.controller;

import lotto.controller.dto.LottoTicketPurchaseRequest;
import lotto.controller.dto.LottoAutoPurchaseResponse;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.service.LottoAutoService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAutoPurchaseController {

    private final LottoAutoService lottoAutoService;

    public LottoAutoPurchaseController() {
        this.lottoAutoService = new LottoAutoService();
    }

    public LottoAutoPurchaseResponse purchaseLottoAutoTicket(LottoTicketPurchaseRequest request) {
        LottoTicket lottoTicket = lottoAutoService.purchaseLottoTicket(request.getPurchaseAmount());
        return new LottoAutoPurchaseResponse(lottoTicket.getCount(), assembleLottoNumbers(lottoTicket.getLottoList()));
    }

    private List<String> assembleLottoNumbers(List<Lotto> lottoList) {
        return lottoList.stream().map(lotto -> Arrays.toString(lotto.getLottoNumbers())).collect(Collectors.toList());
    }
}
