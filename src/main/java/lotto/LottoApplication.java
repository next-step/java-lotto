package lotto;

import lotto.controller.LottoController;
import lotto.controller.dto.LottoPurchaseParam;
import lotto.controller.dto.LottoResultParam;
import lotto.controller.dto.WinningLottoTicketParam;
import lotto.service.LottoService;
import lotto.service.domain.LottoResultMaker;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.domain.factory.LottoTicketFactory;
import lotto.service.model.LottoNumbers;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoPrice;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        LottoController lottoController = new LottoController(new LottoService(new LottoResultMaker(),
                                                                               new LottoTicketFactory()),
                                                              new ResultView());
        InputView inputView = new InputView();

        // 로또 구입
        LottoTickets lottoTickets = lottoApplication.purchaseLottoTickets(lottoController, inputView);

        // 당첨 번호
        WinningLottoTicket winningLottoTicket = lottoApplication.getWinningLottoTicket(lottoController, inputView);

        // 당첨 통계
        lottoController.checkLottoResult(LottoResultParam.of(lottoTickets, winningLottoTicket));
    }

    private LottoTickets purchaseLottoTickets(LottoController lottoController, InputView inputView) {
        LottoPrice purchasePrice = inputView.inputPurchasePrice();
        Integer manualLottoCount = inputView.inputManualCount();
        List<LottoNumbers> lottoNumbers = inputView.inputManualLottoNumbers(manualLottoCount);

        return lottoController.purchaseLottoTickets(LottoPurchaseParam.of(purchasePrice, lottoNumbers));
    }

    private WinningLottoTicket getWinningLottoTicket(LottoController lottoController, InputView inputView) {
        List<Integer> winningLottoNumbers = inputView.inputWinningLottoNumberOfLastWeeks();
        Integer bonusNumber = inputView.inputBonusNumber();

        return lottoController.getWinningLottoTicket(WinningLottoTicketParam.of(winningLottoNumbers, bonusNumber));
    }
}
