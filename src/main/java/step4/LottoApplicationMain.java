package step4;

import step4.controller.LottoTicketMaker;
import step4.domain.Lotto;
import step4.domain.LottoNumber;
import step4.domain.LottoWinning;
import step4.view.LottoInputUi;
import step4.view.LottoOuputUi;

import java.util.List;

public class LottoApplicationMain {
    public static void main(String[] args) {
        int purchaseAmount = LottoInputUi.inputPurchaseAmount();
        int manualLottoQty = LottoInputUi.inputManualLottoCount();

        List<Lotto> manualLottoNumbers = LottoInputUi.askManualLottoNumbers(manualLottoQty);

        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(purchaseAmount, manualLottoQty, manualLottoNumbers);

        LottoOuputUi.printLottoCount(lottoTicketMaker.lottoAutoPurchaseQty(), manualLottoQty);

        LottoOuputUi.printLottos(lottoTicketMaker.getLottoTicket().getLottos());

        LottoNumber lottoNumber = LottoNumber.of(LottoInputUi.inputLastWeekNumber(), LottoInputUi.inputBonusNumber());

        LottoWinning lottoWinning = LottoWinning.of(lottoNumber, lottoTicketMaker.getLottoTicket());

        LottoOuputUi.printStatistics(lottoWinning.getLottoWinningMap());
        LottoOuputUi.printTotalReturn(lottoWinning.getTotalYield(purchaseAmount));

        LottoInputUi.close();
    }
}
