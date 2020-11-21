package step2;

import step2.controller.LottoTicketMaker;
import step2.domain.LottoNumber;
import step2.domain.LottoWinning;
import step2.view.LottoInputUi;
import step2.view.LottoOuputUi;

public class LottoApplicationMain {
    public static void main(String[] args) {

        int purchaseAmount = LottoInputUi.inputPurchaseAmount();
        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(purchaseAmount);

        LottoOuputUi.printLottoCount(lottoTicketMaker.lottoPurchaseQty());
        LottoOuputUi.printLottos(lottoTicketMaker.getLottos());

        LottoNumber lottoNumber = LottoNumber.of(LottoInputUi.inputLastWeekNumber());
        LottoWinning lottoWinning = LottoWinning.of(lottoNumber.getLastWeekNumber(), lottoTicketMaker.getLottos());

        LottoOuputUi.printStatistics(lottoWinning.getLottoWinningMap());
        LottoOuputUi.printTotalReturn(lottoWinning.getTotalYield(purchaseAmount));

        LottoInputUi.close();
    }
}
