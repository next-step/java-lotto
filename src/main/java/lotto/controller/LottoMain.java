package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.service.LottoService;
import lotto.ui.LottoHitInfo;
import lotto.ui.LottoRequest;
import lotto.ui.LottoResult;

public class LottoMain {

    public static void main(String[] args) {
        LottoRequest request = LottoRequest.inputBuyingPrice();
        LottoService lottoService = new LottoService();
        LottoTickets lottoTickets = lottoService.buyLotto(request);
        LottoHitInfo lottoHitInfo = LottoHitInfo.inputHitInfo();
        LottoResult lottoResult = lottoTickets.createLottoResult(lottoHitInfo);
        lottoResult.printWinningStatistics();
    }
}
