package step2;

import step2.controller.LottoTicketMaker;
import step2.domain.LottoWinning;
import step2.view.LottoInputUi;
import step2.view.LottoOuputUi;

public class LottoApplicationMain {
    public static void main(String[] args) {

        int purchaseAmount = LottoInputUi.inputPurchaseAmount();
        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(purchaseAmount);

        LottoOuputUi.printLottoCount(lottoTicketMaker.lottoPurchaseQty());
        LottoOuputUi.printLottos(lottoTicketMaker.getLottos());

        String lastWeekWinningNumbers = LottoInputUi.inputLastWeekNumber();
        LottoWinning lottoWinning = LottoWinning.of(lastWeekWinningNumbers, lottoTicketMaker.getLottos());

        LottoOuputUi.printStatistics(lottoWinning.getLottoWinningMap());
        LottoOuputUi.printTotalReturn(lottoWinning.getTotalYield(purchaseAmount));

        LottoInputUi.close();
    }
}
