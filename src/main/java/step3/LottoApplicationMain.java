package step3;

import step3.controller.LottoTicketMaker;
import step3.domain.LottoNumber;
import step3.domain.LottoWinning;
import step3.view.LottoInputUi;
import step3.view.LottoOuputUi;

public class LottoApplicationMain {
    public static void main(String[] args) {

        int purchaseAmount = LottoInputUi.inputPurchaseAmount();
        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(purchaseAmount);

        LottoOuputUi.printLottoCount(lottoTicketMaker.lottoPurchaseQty());
        LottoOuputUi.printLottos(lottoTicketMaker.getLottos());

        LottoNumber lottoNumber = LottoNumber.of(LottoInputUi.inputLastWeekNumber(), LottoInputUi.inputBonusNumber());

        LottoWinning lottoWinning = LottoWinning.of(lottoNumber, lottoTicketMaker.getLottos());

        LottoOuputUi.printStatistics(lottoWinning.getLottoWinningMap());
        LottoOuputUi.printTotalReturn(lottoWinning.getTotalYield(purchaseAmount));

        LottoInputUi.close();
    }
}
