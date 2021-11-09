package lotto;

import lotto.controller.LottoController;
import lotto.controller.dto.LottoPurchaseRequest;
import lotto.service.domain.LottoTicket;
import lotto.service.model.LottoTickets;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoApplication {
    private static InputView inputView = new InputView();
    private static LottoController lottoController = new LottoController();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        // 로또 구입
        Integer purchasePrice = inputView.inputPurchasePrice();
        LottoTickets lottoTickets = lottoController.purchaseLottoTickets(
                LottoPurchaseRequest.from(purchasePrice));
        resultView.printLottoTickets(lottoTickets);

        // 당첨 번호 입력
        List<Integer> winningNumbers = inputView.inputLastWeeksWinningNumber();
        LottoTicket winningLottoTicket = lottoController.getWinningLottoTicket(winningNumbers);

        // 당첨 통계
        // service -> (비즈니스 로직 통계)
        // result (DTO)
        // -> output
    }
}
