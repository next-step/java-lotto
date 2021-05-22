package lotto.controller;

import lotto.controller.dto.LottoNumbersDto;
import lotto.controller.dto.LottoPurchaseRequest;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.service.LottoPurchaseService;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseController {

    private final LottoPurchaseService purchaseService;

    public LottoPurchaseController() {
        this.purchaseService = new LottoPurchaseService();
    }

    public LottoPurchaseResponse purchaseTickets(LottoPurchaseRequest request) {
        LottoTickets lottoTickets = purchaseService.purchaseTickets(request.getPurchaseAmount());
        return assemblePurchaseResponse(lottoTickets);
    }

    private LottoPurchaseResponse assemblePurchaseResponse(LottoTickets lottoTickets) {
        List<LottoNumbersDto> lottoNumbersDtoList = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoNumbersDtoList.add(new LottoNumbersDto(assembleLottoNumbers(lottoTicket)));
        }
        return new LottoPurchaseResponse(lottoNumbersDtoList);
    }

    private List<Integer> assembleLottoNumbers(LottoTicket lottoTicket) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoTicket.lottoNumbers()) {
            lottoNumbers.add(lottoNumber.number());
        }
        return lottoNumbers;
    }
}
