package lottogame.controller;

import java.util.List;
import java.util.Set;
import lottogame.controller.spi.Inputer;
import lottogame.controller.spi.Viewer;
import lottogame.domain.LottoCheckManager;
import lottogame.domain.LottoPurchaseManager;
import lottogame.domain.response.LottoCheckedResponse;
import lottogame.domain.response.LottoTicketResponse;
import lottogame.domain.spi.NumberGenerator;

public class LottoController {

    private final Inputer inputer;
    private final Viewer viewer;
    private final LottoPurchaseManager lottoPurchaseManager;

    public LottoController(Inputer purchaseInputer, Viewer purchaseViewer, NumberGenerator numberGenerator) {
        this.inputer = purchaseInputer;
        this.viewer = purchaseViewer;
        this.lottoPurchaseManager = new LottoPurchaseManager(numberGenerator);
    }

    public void run() {
        List<LottoTicketResponse> lottoTicketResponses = purchaseLottoTickets();
        checkResult(lottoTicketResponses);
    }

    private List<LottoTicketResponse> purchaseLottoTickets() {
        int money = inputer.inputMoney();
        List<LottoTicketResponse> lottoTicketRespons = lottoPurchaseManager.purchase(money);
        viewer.drawLottoTicketResponses(lottoTicketRespons);
        return lottoTicketRespons;
    }

    private void checkResult(List<LottoTicketResponse> lottoTicketResponses) {
        Set<Integer> lottoResultNumbers = inputer.inputWinningLottoNumbers();
        Integer bonusNumber = inputer.inputBonusLottoNumber();
        LottoCheckManager lottoCheckManager = new LottoCheckManager(lottoResultNumbers, bonusNumber);
        LottoCheckedResponse lottoPrizes = lottoCheckManager.checkResult(null);

        viewer.drawLottoCheckedResponse(lottoPrizes);
    }

}
