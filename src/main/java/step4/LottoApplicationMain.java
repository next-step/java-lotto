package step4;

import step4.controller.LottoTicketMaker;
import step4.domain.*;
import step4.view.LottoInputUi;
import step4.view.LottoOuputUi;

import java.util.List;

public class LottoApplicationMain {
    public static void main(String[] args) {
        int purchaseAmount = LottoInputUi.inputPurchaseAmount();
        Amount amount = Amount.of(purchaseAmount);

        int manualLottoQty = LottoInputUi.inputManualLottoCount();

        String manualLottoNumbers = LottoInputUi.askManualLottoNumbers();
        Numbers numbers = Numbers.of(manualLottoNumbers);

        List<Lotto> lottos = LottoTicketMaker.askManualLottoNumbers(manualLottoQty, numbers.getLottoNumber());
        LottoTicketMaker lottoTicketMaker = LottoTicketMaker.of(amount, manualLottoQty, lottos);

        LottoOuputUi.printLottoCount(lottoTicketMaker.lottoAutoPurchaseQty(), manualLottoQty);
        LottoOuputUi.printLottos(lottoTicketMaker.getLottoTicket().getLottos());

        String lastWeekNumber = LottoInputUi.inputLastWeekNumber();
        numbers = Numbers.of(lastWeekNumber);

        String bonusNumber = LottoInputUi.inputBonusNumber();

        LottoNumbers lottoNumbers = LottoNumbers.of(numbers, bonusNumber);
        LottoGameWinning lottoWinning = LottoGameWinning.of(lottoNumbers, lottoTicketMaker.getLottoTicket());

        LottoOuputUi.printStatistics(lottoWinning.getLottoWinningMap());
        LottoOuputUi.printTotalReturn(lottoWinning.getTotalYield(purchaseAmount));

        LottoInputUi.close();
    }
}
