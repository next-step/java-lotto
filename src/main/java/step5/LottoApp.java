package step5;

import step5.domain.LottoTicket;
import step5.domain.ManualLottoTicket;
import step5.view.InputView;

public class LottoApp {
    public static void main(String[] args) {
        Integer purchaseAmount = InputView.requirePurchaseAmount();
        Integer numberOfManualLotto = InputView.requireNumberOfManualLotto();
        LottoTicket manualLottoTicket = new ManualLottoTicket(InputView.requireManualLottoNumber());
    }
}
