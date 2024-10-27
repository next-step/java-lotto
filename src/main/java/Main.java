import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        LottoInputView.initiateScanner();
        List<Lotto> purchasedLottos = LottoInputView.createPurchasedLottos(LottoInputView.scanAmount());

        LottoOutputView.printPurchaseInfo(purchasedLottos);

        Lotto winLotto = LottoInputView.createLottoWithScan(LottoInputView.scanWinNumbers());
        
        LottoOutputView.printResultInfo(new LottoChecker(purchasedLottos, winLotto));
    }
}
