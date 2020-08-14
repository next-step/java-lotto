package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoMain {
    public static void main(String[] args) {
        // 입력 시작
        int price = LottoInputView.purchasePrice();
        int manualCount = LottoInputView.manualCount();

        LottoInputView.manualLottoNumberStart();
        LottoShop lottoShop = LottoShop.purchasePrice(price)
                .buyManual(manualCount, () -> Lotto.fromString(LottoInputView.manualLottoNumber()))
                .buyAuto();

        Lottos lottos = lottoShop.getLottos();

        LottoResultView.printPurchasedLottoNumbers(lottoShop);

        String winningNumbers = LottoInputView.lastWeekWinningNumber();
        int bonusBall = LottoInputView.bonusBall();
        // 입력 종료

        WinningLotto winningLotto = new WinningLotto(Lotto.fromString(winningNumbers), LottoNumber.of(bonusBall));
        LottoResult lottoResult = winningLotto.match(lottos);

        // 결과 출력 시작
        LottoResultView.printWinningResult(lottoResult.getRankingMap());
        LottoResultView.printSaveOfReturn(lottoResult.getSaveOfReturn());
        // 결과 출력 종료
    }
}
