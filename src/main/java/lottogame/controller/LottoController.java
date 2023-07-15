package lottogame.controller;

import lottogame.controller.spi.LottoInputer;
import lottogame.controller.spi.LottoViewer;
import lottogame.domain.LottoShop;
import lottogame.domain.LottoTicket;
import lottogame.domain.spi.NumberGenerator;
import lottogame.service.LottoService;
import lottogame.service.request.LottoPurchaseRequest;
import lottogame.service.response.LottoCheckResponse;

import java.util.List;
import java.util.Set;

public class LottoController {

    private final LottoInputer lottoInputer;
    private final LottoViewer lottoViewer;
    private final LottoService lottoService;

    public LottoController(LottoInputer lottoInputer, LottoViewer lottoViewer, LottoService lottoService) {
        this.lottoInputer = lottoInputer;
        this.lottoViewer = lottoViewer;
        this.lottoService = lottoService;
    }

    public List<LottoTicket> purchaseLottoTickets(NumberGenerator numberGenerator) {
        LottoPurchaseRequest lottoPurchaseRequest = lottoInputer.inputLottoPurchaseRequest();

        LottoShop lottoShop = new LottoShop();
        List<LottoTicket> lottoTickets = lottoShop.purchase(lottoPurchaseRequest, numberGenerator);

        lottoViewer.draw(lottoTickets);
        return lottoTickets;
    }

    public void checkResult(List<LottoTicket> lottoTickets) {
        Set<Integer> winningLottoNumbers = lottoInputer.inputWinningLottoNumbers();
        Integer bonusNumber = lottoInputer.inputBonusLottoNumber();

        LottoCheckResponse lottoCheckResponse = lottoService.checkResult(lottoTickets, winningLottoNumbers, bonusNumber);

        lottoViewer.draw(lottoCheckResponse);
    }
}
