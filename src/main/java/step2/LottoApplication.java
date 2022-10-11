package step2;

import step2.domain.LottoGame;
import step2.domain.LottoNumber;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        OutputView.printPriceNotification();
        int price = InputView.inputPrice();
        OutputView.printPurchaseResult(price);
        LottoGame lottoGame = LottoGame.newInstance();
        int purchaseCount = lottoGame.makeLottoTicket(price);
        List<LottoNumber> lottoNumbers = lottoGame.playLotto(purchaseCount);
    }
}
