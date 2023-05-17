package lotto;

import lotto.domain.*;
import lotto.dto.LottoTicketInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Collections;
import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {
        int price = InputView.getPriceFromUser();
        int manuallyPurchaseAmount = InputView.getManualPurchaseAmountFromUser();
        PurchaseAmount purchaseAmount = PurchaseAmount.of(price, manuallyPurchaseAmount);
        List<String> manuallyWrittenNumbers =
                InputView.getManualPurchaseLottoNumberFromUser(purchaseAmount.getManuallyPurchaseAmount());

        LottoGenerator lottoGenerator = new LottoGenerator(Collections::shuffle);
        LottoMachine lottoMachine = new LottoMachine(lottoGenerator);
        Clerk clerk = new Clerk(lottoMachine);

        LottoTicket ticket = clerk.buyTicket(purchaseAmount, manuallyWrittenNumbers);
        ResultView.printLottoTicketInfo(purchaseAmount, LottoTicketInfo.from(ticket));

        String winNumbers = InputView.getWinNumberFromUser();
        int bonusNumber = InputView.getBonusNumberFromUser();

        WinningLotto winningLotto = WinningLotto.from(winNumbers, bonusNumber);

        Matches matches = ticket.getMatches(winningLotto);
        LottoResult result = LottoResult.from(price, matches);

        ResultView.printLottoResult(result);
    }
}
