package lottogame.controller;

import lottogame.controller.spi.LottoInputer;
import lottogame.controller.spi.LottoViewer;
import lottogame.domain.LottoResult;
import lottogame.domain.LottoShop;
import lottogame.domain.LottoTicket;
import lottogame.domain.WinningLotto;
import lottogame.domain.spi.NumberGenerator;
import lottogame.controller.request.LottoPurchaseRequest;
import lottogame.controller.response.LottoCheckResponse;

import java.util.List;
import java.util.Set;

public class LottoController {

    private final LottoInputer lottoInputer;
    private final LottoViewer lottoViewer;

    public LottoController(LottoInputer lottoInputer, LottoViewer lottoViewer) {
        this.lottoInputer = lottoInputer;
        this.lottoViewer = lottoViewer;
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

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
        LottoResult lottoResult = new LottoResult(winningLotto.toLottoRanks(lottoTickets));

        lottoViewer.draw(new LottoCheckResponse(lottoResult.getEarningRate(), lottoResult.getLottoRankCounts()));
    }
}
