package step4;

import step4.controller.LottoTicketMaker;
import step4.domain.*;
import step4.util.LottoNumberQtyValidate;
import step4.util.NumbersValidate;
import step4.view.LottoInputUi;
import step4.view.LottoOuputUi;

import java.util.List;

public class LottoApplicationMain {
    public static void main(String[] args) {
        int purchaseAmount = LottoInputUi.inputPurchaseAmount();
        Amount amount = Amount.of(purchaseAmount);

        int manualLottoQty = LottoInputUi.inputManualLottoCount();
        LottoNumberQtyValidate.validate(manualLottoQty);

        List<Numbers> numbers = LottoInputUi.askManualLottoNumbers(manualLottoQty);
        List<Lotto> manualLottoNumbers = LottoTicketMaker.askManualLottoNumbers(numbers);

        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(amount, manualLottoQty, manualLottoNumbers);

        LottoOuputUi.printLottoCount(lottoTicketMaker.lottoAutoPurchaseQty(), manualLottoQty);
        LottoOuputUi.printLottos(lottoTicketMaker.getLottoTicket().getLottos());

        Numbers lastWeekNumber = LottoInputUi.inputLastWeekNumber();
        NumbersValidate.validate(lastWeekNumber.getLottoNumber());

        Numbers bonusNumber = LottoInputUi.inputBonusNumber();

        LottoNumbers lottoNumbers = LottoNumbers.of(lastWeekNumber, bonusNumber.getLottoNumber());
        LottoGameWinning lottoWinning = LottoGameWinning.of(lottoNumbers, lottoTicketMaker.getLottoTicket());

        LottoOuputUi.printStatistics(lottoWinning.getLottoWinningMap());
        LottoOuputUi.printTotalReturn(lottoWinning.getTotalYield(purchaseAmount));

        LottoInputUi.close();
    }
}
