package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        // 입력 시작
        int price = LottoInputView.purchasePrice();
        List<Lotto> lottos = LottoShop.buyAuto(price);
        LottoResultView.printPurchasedLottoNumbers(lottos);

        String winningNumbers = LottoInputView.lastWeekWinningNumber();
        int bonusBall = LottoInputView.bonusBall();
        // 입력 종료

        LottoResult lottoResult = LottoGame.match(
            Lotto.fromString(winningNumbers), LottoNumber.of(bonusBall), lottos);

        // 결과 출력 시작
        LottoResultView.printWinningResult(lottoResult.getRankingMap());
        LottoResultView.printSaveOfReturn(LottoUtil.calculateSaveOfReturn(price, lottoResult.getTotalPrize()));
        // 결과 출력 종료
    }
}
