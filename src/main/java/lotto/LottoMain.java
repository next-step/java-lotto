package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoMain {
    public static void main(String[] args) {
        // 입력 시작
        int price = LottoInputView.purchasePrice();
        Lottos lottos = LottoShop.buyAuto(price);
        LottoResultView.printPurchasedLottoNumbers(lottos);

        String winningNumbers = LottoInputView.lastWeekWinningNumber();
        int bonusBall = LottoInputView.bonusBall();
        // 입력 종료

        LottoGame lottoGame = new LottoGame(Lotto.fromString(winningNumbers), LottoNumber.of(bonusBall), price);
        LottoResult lottoResult = lottoGame.match(lottos);

        // 결과 출력 시작
        LottoResultView.printWinningResult(lottoResult.getRankingMap());
        LottoResultView.printSaveOfReturn(lottoResult.getSaveOfReturn());
        // 결과 출력 종료
    }
}
