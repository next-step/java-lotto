package step4;

import step4.controller.LottoTicketMaker;
import step4.domain.LottoNumber;
import step4.domain.LottoWinning;
import step4.view.LottoInputUi;
import step4.view.LottoOuputUi;

public class LottoApplicationMain {
    public static void main(String[] args) {
        int purchaseAmount = LottoInputUi.inputPurchaseAmount();
        int manualLottoQty = LottoInputUi.inputManualLottoCount();

        String aaa = LottoInputUi.inputManualLottoNumbers();
        // 입력받은 List 저장 lottos

        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(purchaseAmount);

        LottoOuputUi.printLottoCount(lottoTicketMaker.lottoPurchaseQty(), manualLottoQty);

        LottoOuputUi.printLottos(lottoTicketMaker.getLottoTicket().getLottos());

        LottoNumber lottoNumber = LottoNumber.of(LottoInputUi.inputLastWeekNumber(), LottoInputUi.inputBonusNumber());

        LottoWinning lottoWinning = LottoWinning.of(lottoNumber, lottoTicketMaker.getLottoTicket());

        LottoOuputUi.printStatistics(lottoWinning.getLottoWinningMap());
        LottoOuputUi.printTotalReturn(lottoWinning.getTotalYield(purchaseAmount));

        LottoInputUi.close();
    }
}
