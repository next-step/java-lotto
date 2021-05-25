package lotto.controller;

import lotto.controller.dto.LottoNumbersAssembler;
import lotto.controller.dto.WinInquiryAssembler;
import lotto.controller.dto.WinInquiryRequest;
import lotto.controller.dto.WinInquiryResponse;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRanks;
import lotto.service.LottoWinService;

public class LottoWinController {

    private final LottoWinService lottoWinService;

    public LottoWinController() {
        lottoWinService = new LottoWinService();
    }

    public WinInquiryResponse inquiryWin(WinInquiryRequest request) {
        LottoRanks lottoRanks = lottoWinService.inquiryWin(LottoNumbersAssembler.assemblePurchaseTickets(request.getPurchaseNumbers()), LottoNumbersAssembler.assembleLottoNumbers(request.getWinNumbers()), LottoNumber.of(request.getBonusNumber()));
        return WinInquiryAssembler.assembleWinInquiryResponse(lottoRanks);
    }

}
