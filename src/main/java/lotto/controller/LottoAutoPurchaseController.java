package lotto.controller;

import lotto.controller.dto.LottoTicketPurchaseRequest;
import lotto.controller.dto.LottoTicketPurchaseResponse;
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

    public LottoTicketPurchaseResponse purchaseLottoAutoTicket(LottoTicketPurchaseRequest request) {
        LottoTicket lottoTicket = lottoAutoService.purchaseLottoTicket(request.getPurchaseAmount());
        return new LottoTicketPurchaseResponse(0, lottoTicket.getCount(), assembleLottoNumbers(lottoTicket.getLottoList())); // TODO: 수동로또 구매갯수 세팅로
    }

    private List<String> assembleLottoNumbers(List<Lotto> lottoList) {
        return lottoList.stream().map(lotto -> Arrays.toString(lotto.getLottoNumbers())).collect(Collectors.toList());
    }
}
