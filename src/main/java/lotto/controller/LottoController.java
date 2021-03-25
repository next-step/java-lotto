package lotto.controller;

import lotto.controller.dto.LottoAutoPurchaseRequest;
import lotto.controller.dto.LottoAutoPurchaseResponse;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.service.LottoAutoService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoAutoService lottoAutoService;

    public LottoController() {
        this.lottoAutoService = new LottoAutoService();
    }

    public LottoAutoPurchaseResponse purchaseLottoAutoTicket(LottoAutoPurchaseRequest request) {
        LottoTicket lottoTicket = lottoAutoService.purchaseLottoTicket(request.getPurchaseAmount());
        return new LottoAutoPurchaseResponse(lottoTicket.getCount(), assembleLottoNumbers(lottoTicket.getLottoList()));
    }

    private List<String> assembleLottoNumbers(List<Lotto> lottoList) {
        return lottoList.stream().map(lotto -> Arrays.toString(lotto.getLottoNumbers())).collect(Collectors.toList());
    }
}
