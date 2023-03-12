package lotto.controller;

import lotto.domain.LottoTicketList;
import lotto.service.LottoService;
import lotto.ui.LottoHitInfo;
import lotto.ui.LottoBuyingRequest;
import lotto.ui.LottoResult;

public class LottoMain {

    public static void main(String[] args) {
        LottoBuyingRequest request = LottoBuyingRequest.create();
        LottoService lottoService = new LottoService();
        LottoTicketList lottoTicketList = lottoService.buyLotto(request);
        LottoHitInfo lottoHitInfo = LottoHitInfo.inputHitInfo();
        LottoResult lottoResult = LottoResult.from(lottoTicketList, lottoHitInfo);
        lottoResult.printLottoNumbers();
        lottoResult.printWinningStatistics();
    }
}
