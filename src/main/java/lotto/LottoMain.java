package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoMain {
    public static void main(String[] args) {
        // 입력 시작
        int price = LottoInputView.purchasePrice();
        int manualCount = LottoInputView.manualCount();

        Lottos lottos = LottoShop.purchase(price, manualCount);

        LottoInputView.manualLottoNumberStart();
        for (int i = 0; i < manualCount; i++) {
            lottos.add(Lotto.fromString(LottoInputView.manualLottoNumber()));
        }

        int autoCount = lottos.fillAuto();

        // 로또 번호 출력 시작
        LottoResultView.printLottoCount(manualCount, autoCount);
        LottoResultView.printLottos(lottos);
        // 로또 번호 출력 종료

        String winningNumbers = LottoInputView.lastWeekWinningNumber();
        int bonusBall = LottoInputView.bonusBall();
        // 입력 종료

        WinningLotto winningLotto = new WinningLotto(Lotto.fromString(winningNumbers), LottoNumber.of(bonusBall));
        LottoResult lottoResult = lottos.matchWinningLotto(winningLotto);

        // 결과 출력 시작
        LottoResultView.printWinningResult(lottoResult.getRankingMap());
        LottoResultView.printSaveOfReturn(lottoResult.getSaveOfReturn());
        // 결과 출력 종료
    }
}
